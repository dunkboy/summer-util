package org.poor.framework.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.poor.framework.test.domain.po.Student;

@Mapper
public interface StudentDao extends BaseMapper<Student>
{

}
