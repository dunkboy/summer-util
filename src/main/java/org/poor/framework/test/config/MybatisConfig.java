package org.poor.framework.test.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.poor.framework.test.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import javax.transaction.SystemException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@MapperScan("org.poor.framework.**.dao")
public class MybatisConfig implements TransactionManagementConfigurer
{

    private static final String MAPPER_PATH = "classpath*:**/dao/mapper/*.xml";

    @Bean("dataSource")
    @Lazy
    public DataSource dynamicDataSource()
    {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(16);
        targetDataSources.put("mysql8012DataSource", mysql8012DataSource());
        targetDataSources.put("mysql5717DataSource", mysql5717DataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(mysql8012DataSource());
        return dynamicDataSource;
    }

    @Bean(destroyMethod = "close", initMethod = "init", name = "mysql8012DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql-8.0.12")
    public DataSource mysql8012DataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(destroyMethod = "close", initMethod = "init", name = "mysql5717DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql-5.7.17")
    public DataSource mysql5717DataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
    {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        //设置dataSource
        bean.setDataSource(dataSource);
        //设置Mapper 所对应的 XML 文件位置
        PathMatchingResourcePatternResolver pathMatchResolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperLocations;
        try
        {
            mapperLocations = pathMatchResolver.getResources(MAPPER_PATH);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        bean.setMapperLocations(mapperLocations);
        //设置
        bean.setTypeAliasesPackage("org.poor.framework.**.po," +
                "org.poor.framework.**.vo," +
                "org.poor.framework.**.query");
        //设置枚举路径
        bean.setTypeEnumsPackage("org.poor.framework.**.enums");
        //设置mybatis配置
        MybatisConfiguration conf = new MybatisConfiguration();
        bean.setConfiguration(conf);
        //设置全局配置
        GlobalConfig global = new GlobalConfig();
        global.setBanner(true);
        global.setRefresh(true);
        global.setSqlInjector(new LogicSqlInjector());
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setDbType(DbType.MYSQL);
        dbConfig.setTablePrefix("cb_");
        dbConfig.setIdType(IdType.INPUT);
        global.setDbConfig(dbConfig);
        bean.setGlobalConfig(global);
        //设置分页
        bean.setPlugins(new Interceptor[]{paginationInterceptor()});
        try
        {
            return bean.getObject();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


    public PaginationInterceptor paginationInterceptor()
    {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        /*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler()
        {

            @Override
            public Expression getTenantId()
            {
                return new LongValue(1L);
            }

            @Override
            public String getTenantIdColumn()
            {
                return "tenant_id";
            }

            @Override
            public boolean doTableFilter(String tableName)
            {
                // 这里可以判断是否过滤表
                /*if ("user".equals(tableName)) {
                    return true;
                }*/
                return false;
            }
        });

        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
//        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
//            @Override
//            public boolean doFilter(MetaObject metaObject) {
//                MappedStatement ms = PluginUtils.getMappedStatement(metaObject);
//                // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
//                if ("com.baomidou.springboot.mapper.UserMapper.selectListBySQL".equals(ms.getId())) {
//                    return true;
//                }
//                return false;
//            }
//        });
        return paginationInterceptor;
    }


    //事务处理
    @Bean(destroyMethod = "close", initMethod = "init")
    public UserTransactionManager userTransactionManager()
    {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    @Bean()
    public UserTransactionImp userTransactionImp()
    {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        try
        {
            userTransactionImp.setTransactionTimeout(300);
        }
        catch (SystemException e)
        {
            throw new RuntimeException(e);
        }
        return userTransactionImp;
    }

    @Bean
    public JtaTransactionManager jtaTransactionManager()
    {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(userTransactionManager());
        jtaTransactionManager.setUserTransaction(userTransactionImp());
        return jtaTransactionManager;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager()
    {
        return jtaTransactionManager();
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager)
    {
        return new TransactionTemplate(platformTransactionManager);
    }

}
