package org.poor.framework.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.poor.framework.test.domain.po.Student;

import java.util.Collection;
import java.util.List;

@Mapper
public interface StudentDao extends BaseMapper<Student>
{
    void batchInsert(@Param(Constants.COLLECTION) Collection<Student> students);
}
