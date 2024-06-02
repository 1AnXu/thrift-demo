package com.yanxu.client.student.controller;

import com.yanxu.client.student.service.StudentServiceInf;
import com.yanxu.thriftInterface.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thrift")
public class StudentController {
    @Autowired
    StudentServiceInf studentService;

    @GetMapping("get")
    public Student getStudeByName(String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("save")
    public Student save() {
        //直接模拟前端传递的数据
        Student student = new Student();
        student.setName("AAA");
        student.setAge(10);
        student.setAddress("BBB");
        //调用保存服务
        studentService.save(student);
        return student;
    }
}

