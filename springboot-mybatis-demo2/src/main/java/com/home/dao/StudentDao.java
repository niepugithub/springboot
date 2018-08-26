package com.home.dao;

import com.home.pojo.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    List<Student> getAll();

    Student getById(int id);

    List<Student> getByNameLike(String name);

    Student getByIdAndName(Student student);

    Student getByIdAndNameWithParamMap(HashMap<String, Object> params);

    List<Student> getByCreateTime(Date date);

    int insertStudent(Student student);

    int deleteById(Student student);
}
