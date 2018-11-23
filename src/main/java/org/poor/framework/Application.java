package org.poor.framework;

import com.github.drinkjava2.jdialects.Dialect;
import com.github.drinkjava2.jsqlbox.SqlBoxContext;
import com.github.drinkjava2.jtransactions.spring.SpringTxConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
public class Application
{
    @Autowired()
    @Qualifier("dataSource")
    DataSource ds;

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SqlBoxContext createDefaultSqlBoxContext()
    {
        SqlBoxContext ctx = new SqlBoxContext(ds);
        ctx.setConnectionManager(SpringTxConnectionManager.instance());
        ctx.setAllowShowSQL(true);
        ctx.setDialect(Dialect.MySQLDialect);
        ctx.setBatchSize(300);
        SqlBoxContext.setGlobalSqlBoxContext(ctx);// 设定静态全局上下文
        return ctx;
    }

}

