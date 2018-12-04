package org.poor.framework.test.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.poor.framework.test.domain.po.Student;
import org.poor.framework.test.domain.po.StudentQuery;

@Mapper
public interface StudentDao extends CustomBaseMapper<Student>
{

    IPage<Student> findStudentPage(StudentQuery query);
}
