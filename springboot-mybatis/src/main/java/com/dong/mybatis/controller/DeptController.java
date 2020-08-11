package com.dong.mybatis.controller;

import com.dong.mybatis.bean.Department;
import com.dong.mybatis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @date 2020/8/11 20:08
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }


    @GetMapping("/dept")
    public Department getDepartment(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }
}
