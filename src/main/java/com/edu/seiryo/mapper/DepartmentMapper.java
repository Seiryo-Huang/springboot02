package com.edu.seiryo.mapper;

import com.edu.seiryo.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
//在之前的例子中
//只使用了Repository注解，并且此注解是编写到实现类中

//现在，表示本类是一个 MyBatis 的 Mapper文件，后续springboot会帮我们实现自动注入

@Mapper
public interface DepartmentMapper {
    // 获取所有部门信息
//    @Select("select * from Department")
    List<Department> getDepartments();
    // 通过id获得部门
//    @Select("select * from Department where id =${id}")
    Department getDepartment(@Param("id") Integer id);
}
