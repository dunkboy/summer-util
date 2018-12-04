package org.poor.framework.test.domain.po;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: StudentQuery</p>
 * <p>Description: StudentQuery</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/28 15:39</p>
 * @author cb
 * @version 1.0
 **/
@Setter
@Getter
public class StudentQuery extends Page
{
    private String name;
}
