package com.edu.seiryo.controller;

import com.edu.seiryo.entity.Department;
import com.edu.seiryo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//1.使用jdbctemplete默认操作数据库
//<a href="/list">list</a>
//<a href="/add">add</a>
//<a href="/update/1010">update</a>
//<a href="/delete/1008">delete</a>

//2.使用druid数据源，做测试
//在test类中查询出初始化条数，最大连接数
//能够进入druid的配置界面

//3.连接mybatis框架进行数据库增删改查
//3.1.只写mapper接口，通过注解方式进行增删改查
//3.2.编写mapper通过mapper进行增删改查

//导入 Lombok,在pom.xml中
//<dependency>
//            <groupId>org.projectlombok</groupId>
//            <artifactId>lombok</artifactId>
//        </dependency>

//导入静态资源，该标签放在build标签下
//<resources>
//<resource>
//<directory>src/main/java</directory>
//<includes>
//<include>**/*.xml</include>
//</includes>
//<filtering>true</filtering>
//</resource>
//</resources>


@RestController
@Controller
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;
    // 查询全部部门
    @GetMapping("/getDepartments")
    public List<Department> getDepartments(){
        return departmentMapper.getDepartments();
    }
    // 根据id查询部门信息
    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDepartment(id);
    }
}

