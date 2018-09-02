package org.poor.framework.utils.tree.utils;

import org.poor.framework.utils.exception.BuildTreeException;
import org.poor.framework.utils.tree.domain.BasicTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BuildTreeStructure</p>
 * <p>Description: BuildTreeStructure</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/25 21:49</p>
 * @author cb
 * @version 1.0
 **/


public abstract class BuildTreeStructure
{
    /**
     * <p>Description: 拆分获取root节点</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/5/30 16:53</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  source 继承BasicTree的数据集
     * @param  root 装载处理后的结果集
     * @param  clazz 继承BasicTree的类
     */
    public static <T extends BasicTree> void separateTreeRoot(List<T> source, Set<T> root, Class<T> clazz) throws BuildTreeException
    {
        Iterator<T> iterator = source.iterator();

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (next.getParentId().equals(-1L))
            {
                T target = null;
                try
                {
                    target = clazz.newInstance();
                }
                catch (InstantiationException e)
                {
                    throw new BuildTreeException("###build tree structure fail", e);
                }
                catch (IllegalAccessException e)
                {
                    throw new BuildTreeException("###build tree structure fail", e);
                }
                copyProperties(next, target);
                root.add(target);
                iterator.remove();
            }
        }
        recursivePackage(root, source, clazz);
    }

    /**
     * <p>Description:递归封装children</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/5/30 16:54</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  root 装载处理后的结果集
     * @param  split 未处理数据
     * @param  clazz 继承BasicTree的类
     */
    private static <T extends BasicTree> void recursivePackage(Set<T> root, List<T> split, Class<T> clazz)
    {
        root.stream().forEach((T t) -> {
            if (split.size() != 0)
            {
                Set<T> children = new HashSet<>();
                Iterator<T> iterator = split.iterator();
                while (iterator.hasNext())
                {
                    T next = iterator.next();
                    if (t.getId().equals(next.getParentId()))
                    {
                        try
                        {
                            T target = clazz.newInstance();
                            copyProperties(next, target);
                            children.add(target);
                            iterator.remove();
                        }
                        catch (InstantiationException e)
                        {
                            throw new BuildTreeException("###build tree structure fail", e);
                        }
                        catch (IllegalAccessException e)
                        {
                            throw new BuildTreeException("###build tree structure fail", e);
                        }
                    }
                }
                t.setChildren(children);
                recursivePackage(children, split, clazz);
            }
        });

    }
}
