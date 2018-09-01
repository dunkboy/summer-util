package org.poor.framework.exception;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BuildTreeException</p>
 * <p>Description: BuildTreeException</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/25 21:58</p>
 * @author cb
 * @version 1.0
 **/

public class BuildTreeException extends RuntimeException
{
    public BuildTreeException()
    {
        super();
    }

    public BuildTreeException(String message)
    {
        super(message);
    }

    public BuildTreeException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
