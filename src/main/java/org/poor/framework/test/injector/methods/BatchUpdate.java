package org.poor.framework.test.injector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.poor.framework.test.enums.CustomSqlMethod;
import org.poor.framework.utils.annotation.Column;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BatchUpdate</p>
 * <p>Description: 批量更新多条数据不同属性适用于mysql</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/6 20:51</p>
 * @author cb
 * @version 1.0
 **/
public class BatchUpdate extends AbstractMethod
{
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo)
    {
        Map<String, List<String>> map = doBatchUpdateField(modelClass);
        if (CollectionUtils.isEmpty(map))
        {
            return null;
        }
        CustomSqlMethod sqlMethod = CustomSqlMethod.BATCH_UPDATE;
        String sqlSet = getSqlSet(map.get("setProperties"), map.get("filterPropertie").get(0));
        String sqlWhere = getSqlWhere(map.get("filterPropertie").get(0));
        String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), sqlSet, sqlWhere);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource);
    }

    public Map<String, List<String>> doBatchUpdateField(Class<?> modelClass)
    {
        List<Field> fields = Arrays.stream(modelClass.getDeclaredFields()).collect(Collectors.toList());
        List<Field> batchUpdateField = fields.stream().filter(item -> item.getAnnotation(Column.class) != null).collect(Collectors.toList());
        List<Field> batchUpdateSetField = batchUpdateField.stream().filter(item -> item.getAnnotation(Column.class).batchUpdateSet())
                .collect(Collectors.toList());
        List<Field> batchUpdateFilterField = batchUpdateField.stream().filter(item -> item.getAnnotation(Column.class).batchUpdateFilter())
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(batchUpdateSetField))
        {
            return null;
        }
        if (batchUpdateFilterField.size() == 0 || batchUpdateFilterField.size() > 1)
        {
            throw new RuntimeException("###批量更新filter字段@Column(batchUpdateFilter = true)注解指定只能存在一个###");
        }
        List<String> setProperties = batchUpdateSetField.stream().map(Field::getName).collect(Collectors.toList());
        List<String> filterPropertie = batchUpdateFilterField.stream().map(Field::getName).collect(Collectors.toList());
        Map<String, List<String>> map = new HashMap<>(16);
        map.put("setProperties", setProperties);
        map.put("filterPropertie", filterPropertie);
        return map;
    }

    public String getSqlSet(final List<String> setProperties, final String filterPropertie)
    {
        String filterColumn = StringUtils.camelToUnderline(filterPropertie);
        final StringBuffer sb = new StringBuffer("<trim");
        sb.append(" prefix=\"").append("SET").append(StringPool.QUOTE);
        sb.append(" suffixOverrides=\"").append(StringPool.COMMA).append(StringPool.QUOTE);
        sb.append(StringPool.RIGHT_CHEV);
        sb.append(StringPool.NEWLINE);

        for (String setField : setProperties)
        {
            String setColumn = StringUtils.camelToUnderline(setField);
            sb.append("<trim").append(" prefix=\"").append(setColumn).append(" = CASE").append(StringPool.QUOTE);
            sb.append(" suffix=\"").append("END,").append(StringPool.QUOTE);
            sb.append(StringPool.RIGHT_CHEV);
            sb.append(StringPool.NEWLINE);
            sb.append("<foreach");
            sb.append(" collection=\"").append(Constants.COLLECTION).append(StringPool.QUOTE);
            sb.append(" item=\"").append("item").append(StringPool.QUOTE);
            sb.append(StringPool.RIGHT_CHEV).append(StringPool.NEWLINE);
            sb.append("<if test=\"").append("item").append(StringPool.DOT).append(setField).append(" != null").append(StringPool.QUOTE).append(StringPool.RIGHT_CHEV).append(StringPool.NEWLINE);
            sb.append(" when ").append(filterColumn).append(" = ").append(StringPool.HASH_LEFT_BRACE)
                    .append("item").append(StringPool.DOT).append(filterPropertie).append(StringPool.RIGHT_BRACE)
                    .append(" then ").append(StringPool.HASH_LEFT_BRACE).append("item").append(StringPool.DOT).append(setField).append(StringPool.RIGHT_BRACE);
            sb.append(StringPool.NEWLINE);
            sb.append("</if>");
            sb.append(StringPool.NEWLINE);
            sb.append("</foreach>");
            sb.append(StringPool.NEWLINE);
            sb.append("</trim>");
            sb.append(StringPool.NEWLINE);
        }
        return sb.append("</trim>").toString();
    }

    private String getSqlWhere(final String filterPropertie)
    {
        String filterColumn = StringUtils.camelToUnderline(filterPropertie);
        final StringBuffer sb = new StringBuffer(filterColumn);
        sb.append(" IN ").append(StringPool.NEWLINE);
        sb.append("<foreach");
        sb.append(" collection=\"").append(Constants.COLLECTION).append(StringPool.QUOTE);
        sb.append(" item=\"").append("item").append(StringPool.QUOTE);
        sb.append(" separator=\"").append(StringPool.COMMA).append(StringPool.QUOTE);
        sb.append(" open=\"").append(StringPool.LEFT_BRACKET).append(StringPool.QUOTE);
        sb.append(" close=\"").append(StringPool.RIGHT_BRACKET).append(StringPool.QUOTE);
        sb.append(StringPool.RIGHT_CHEV).append(StringPool.NEWLINE);
        sb.append(StringPool.HASH_LEFT_BRACE).append("item").append(StringPool.DOT).append(filterPropertie).append(StringPool.RIGHT_BRACE);
        return sb.append(StringPool.NEWLINE).append("</foreach>").toString();
    }

}
