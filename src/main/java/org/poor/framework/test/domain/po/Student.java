package org.poor.framework.test.domain.po;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;
import org.poor.framework.test.enums.AssignTypeEnum;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: Student</p>
 * <p>Description: Student</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/3 12:11</p>
 * @author cb
 * @version 1.0
 **/
@Data
public class Student
{
    private Long id;
    private Long tenantId;
    @TableLogic
    private Boolean delFlag;
    private String name;
    private AssignTypeEnum assignType;
}
