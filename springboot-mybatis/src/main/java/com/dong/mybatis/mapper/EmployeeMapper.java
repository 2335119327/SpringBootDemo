package com.dong.mybatis.mapper;

import com.dong.mybatis.bean.Employee;

/**
 * @author dong
 * @date 2020/8/11 21:28
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
