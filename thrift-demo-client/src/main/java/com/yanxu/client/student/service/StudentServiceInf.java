package com.yanxu.client.student.service;

import com.yanxu.thriftInterface.Student;

public interface StudentServiceInf {
    //根据名称获取学生信息
    Student getStudentByName(String name);

    //保存学生信息
    void save(Student student);
}
