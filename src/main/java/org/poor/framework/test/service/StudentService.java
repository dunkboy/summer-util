package org.poor.framework.test.service;

import java.util.List;

import org.poor.framework.test.domain.po.Student;

public interface StudentService
{

    void insert(Student s);

    void batchInsert(List<Student> s);

    void batchUpdate(List<Student> s);

    void batchSaveOrUpdate(List<Student> s);

    void batchReplaceInto(List<Student> s);
}
