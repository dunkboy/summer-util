package org.poor.framework.utils.string;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: IStringReplaceProcess</p>
 * <p>Description: IStringReplaceProcess</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/26 10:37</p>
 * @author cb
 * @version 1.0
 **/


public interface IStringReplaceProcess
{
    /**
     * <p>Description:</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/8/26 10:38</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param key         替换关键字
     * @param src         原字符串
     * @param prefixIndex 前缀关键字
     * @param suffixIndex 后缀关键字
     * @return description
     */
    String doReplace(String key, StringBuffer src, int prefixIndex, int suffixIndex);
}
