package org.poor.framework.test.domain.po;

import lombok.Getter;
import lombok.Setter;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BasePageQuery</p>
 * <p>Description: BasePageQuery</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/9/24 16:32</p>
 *
 * @author cb
 * @version 1.0
 **/
@Setter
@Getter
public class BasePageQuery
{

    private Integer current = 1;

    private Integer pageSize = 10;

}
