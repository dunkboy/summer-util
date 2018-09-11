package org.poor.framework.utils.collection;
/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: ArraySortUtils</p>
 * <p>Description: ArraySortUtils</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/4/24 17:14</p>
 * @author cb
 * @version 1.0
 **/

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;


public class ArraySortUtils
{
    /**
     * 根据指定属性对集合顺序排序 ArraySortUtils.sortAsc(list, r -> r.properties());
     *
     * @param data 集合对象
     * @param func 委托
     * @param <T>  数据类型
     * @param <R>  要排序的属性的数据类型
     */
    public static <T, R extends Comparable<? super R>> void sortAsc(List<T> data, Function<T, R> func)
    {
        Comparator<T> comparator = Comparator.comparing(func);
        data.sort(comparator);
    }

    /**
     * 根据指定属性对集合倒序排序
     *
     * @param data 集合对象
     * @param func 委托
     * @param <T>  数据类型
     * @param <R>  要排序的属性的数据类型
     */
    public static <T, R extends Comparable<? super R>> void sortDesc(List<T> data, Function<T, R> func)
    {
        Comparator<T> comparator = Comparator.comparing(func).reversed();
        data.sort(comparator);
    }


    /**
     * 判断是否空集合
     * @param list List<T>
     * @return true 表示是空的集合，false 表示不是空集合
     */
    public static <T> boolean isEmpty(List<T> list)
    {
        return null == list || list.isEmpty();
    }
}
