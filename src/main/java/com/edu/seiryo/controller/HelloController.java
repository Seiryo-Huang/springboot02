package com.edu.seiryo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Controller
public class HelloController {
    /**
     * Spring Boot 默认提供了数据源，默认提供了
     org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * DataSource会注入到jdbcTemplate中，直接使用即可
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from employee";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //新增一个用户
    @GetMapping("/add")
    public String addUser(){
        String sql = "insert into employee(last_name, email,gender,department,birth)  values ('asdf','24736743@qq.com',1,101,'"+ new Date().toLocaleString() +"')";
        jdbcTemplate.update(sql);
        return "addOk";
    }
    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update employee set last_name=?,email=? where id="+id;
        Object[] objects = new Object[2];
        objects[0] = "123";
        objects[1] = "123@sina.com";
        jdbcTemplate.update(sql,objects);

        return "updateOk";
    }
    //删除用户
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql,id);
        return "deleteOk";
    }
}
