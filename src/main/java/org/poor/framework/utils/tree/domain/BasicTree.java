package org.poor.framework.utils.tree.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BasicTree</p>
 * <p>Description: BasicTree</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/8/25 22:10</p>
 * @author cb
 * @version 1.0
 **/

public class BasicTree
{
    /**
     * 自身id
     */
    private Long id;

    /**
     * 父级数据id 顶级父id默认为-1
     */
    private Long parentId = -1L;

    /**
     * 子数据集
     */
    private Set children = new HashSet<>();

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Set getChildren()
    {
        return children;
    }

    public void setChildren(Set children)
    {
        this.children = children;
    }
}
