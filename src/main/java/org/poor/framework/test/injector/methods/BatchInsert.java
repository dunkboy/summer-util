package org.poor.framework.test.injector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.poor.framework.test.enums.CustomSqlMethod;
import org.poor.framework.utils.annotation.Column;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BatchInsert</p>
 * <p>Description: BatchInsert</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/6 20:51</p>
 * @author cb
 * @version 1.0
 **/
public class BatchInsert extends AbstractMethod
{
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo)
    {
        KeyGenerator keyGenerator = new NoKeyGenerator();
        CustomSqlMethod sqlMethod = CustomSqlMethod.BATCH_INSERT;
        Map<String, List<String>> map = doBatchInsertField(modelClass);
        if (CollectionUtils.isEmpty(map))
        {
            return null;
        }
        String columnScript = getAllBatchInsertSqlColumn(map.get("columns"));
        String valuesScript = getAllBatchInsertSqlProperty(map.get("properties"));
        String keyProperty = null;
        String keyColumn = null;
        String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), columnScript, valuesScript);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addInsertMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource, keyGenerator, keyProperty, keyColumn);
    }

    public Map<String, List<String>> doBatchInsertField(Class<?> modelClass)
    {
        List<Field> fields = Arrays.stream(modelClass.getDeclaredFields()).collect(Collectors.toList());
        List<Field> batchInsertField = fields.stream().filter(item -> item.getAnnotation(Column.class) != null)
                .filter(item -> item.getAnnotation(Column.class).batchInsert())
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(batchInsertField))
        {
            return null;
//            throw new RuntimeException("###批量插入需要使用@Column(batchInsert = true)注解指定需要插入的字段###");
        }
        List<String> properties = batchInsertField.stream().map(Field::getName).collect(Collectors.toList());
        List<String> columns = new ArrayList<>();
        for (String property : properties)
        {
            columns.add(StringUtils.camelToUnderline(property));
        }
        Map<String, List<String>> map = new HashMap<>(16);
        map.put("properties", properties);
        map.put("columns", columns);
        return map;
    }

    public String getAllBatchInsertSqlColumn(List<String> columns)
    {
        StringBuilder sb = new StringBuilder("<trim");
        sb.append(" prefix=\"").append(StringPool.LEFT_BRACKET).append(StringPool.QUOTE);
        sb.append(" suffix=\"").append(StringPool.RIGHT_BRACKET).append(StringPool.QUOTE);
        sb.append(" suffixOverrides=\"").append(StringPool.COMMA).append(StringPool.QUOTE);
        sb.append(StringPool.RIGHT_CHEV);
        sb.append(StringPool.NEWLINE);
        for (String column : columns)
        {
            sb.append(column).append(StringPool.COMMA).append(StringPool.NEWLINE);
        }
        return sb.append("</trim>").toString();
    }

    private String getAllBatchInsertSqlProperty(List<String> properties)
    {
        StringBuilder sb = new StringBuilder("<foreach");
        sb.append(" collection=\"").append(Constants.COLLECTION).append(StringPool.QUOTE);
        sb.append(" item=\"").append("item").append(StringPool.QUOTE);
        sb.append(" separator=\"").append(StringPool.COMMA).append(StringPool.QUOTE);
        sb.append(StringPool.RIGHT_CHEV).append(StringPool.NEWLINE);
        sb.append(StringPool.LEFT_BRACKET).append(StringPool.NEWLINE);
        for (String property : properties)
        {
            sb.append(StringPool.HASH_LEFT_BRACE).append("item").append(StringPool.DOT)
                    .append(property).append(StringPool.RIGHT_BRACE).append(StringPool.COMMA)
                    .append(StringPool.NEWLINE);
        }
        sb.delete(sb.lastIndexOf(StringPool.COMMA), sb.length());
        return sb.append(StringPool.RIGHT_BRACKET).append(StringPool.NEWLINE).append("</foreach>").toString();
    }

}
