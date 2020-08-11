package com.dong.mybatis.controller;

import com.dong.mybatis.bean.Department;
import com.dong.mybatis.bean.Employee;
import com.dong.mybatis.mapper.DepartmentMapper;
import com.dong.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @date 2020/8/11 20:08
 */
@RestController
public class EmpController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }

}
