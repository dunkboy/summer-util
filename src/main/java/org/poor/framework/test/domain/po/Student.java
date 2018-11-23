package org.poor.framework.test.domain.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.github.drinkjava2.jdialects.annotation.jpa.Table;
import lombok.Data;
import org.poor.framework.test.enums.AssignTypeEnum;
import org.poor.framework.utils.annotation.Column;

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
@Table(name = "cb_student")
public class Student
{
    @Column(batchUpdateFilter = true, batchSaveOrUpdate = true, batchReplaceInto = true)
    private Long id;
    @Column(batchReplaceInto = true)
    private Long tenantId;
    @TableLogic
    private Boolean delFlag;
    @Column(batchInsert = true, batchUpdateSet = true, batchSaveOrUpdate = true, batchReplaceInto = true)
    private String name;
    @Column(batchInsert = true, batchUpdateSet = true, batchSaveOrUpdate = true, batchReplaceInto = true)
    private AssignTypeEnum assignType;
}
