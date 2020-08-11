package com.dong.mybatis.mapper;

import com.dong.mybatis.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author dong
 * @date 2020/8/11 20:02
 */

//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Update("update department set department_name=#{departmentName} where id=#{id])")
    public int updateDept(Department department);

    //useGeneratedKeys：是不是使用自动生成的组件
    //keyProperty：告诉mybatis哪个时封装组件
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);
}
