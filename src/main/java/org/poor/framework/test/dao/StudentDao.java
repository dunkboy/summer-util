package org.poor.framework.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.poor.framework.test.domain.po.Student;

@Mapper
public interface StudentDao extends CustomBaseMapper<Student>
{

}
