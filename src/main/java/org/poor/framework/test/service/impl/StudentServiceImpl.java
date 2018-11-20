package org.poor.framework.test.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.poor.framework.test.domain.po.Student;
import org.poor.framework.test.dao.StudentDao;
import org.poor.framework.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentDao studentDao;

    @Override
    public void insert(Student s)
    {
        studentDao.insert(s);
    }

    @Override
    public void batchInsert(List<Student> s)
    {
        studentDao.batchInsert(s);
    }

    @Override
    public void batchUpdate(List<Student> s)
    {
        studentDao.batchUpdate(s);
    }

    @Override
    public void batchSaveOrUpdate(List<Student> s)
    {
        studentDao.saveOrUpdate(s);
    }
}
