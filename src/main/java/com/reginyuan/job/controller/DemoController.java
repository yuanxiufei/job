package com.reginyuan.job.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 增加@Controller注解，标识为该类为控制器组件
 * 增加@RestController注解，是@Controller@ResponseBody的组合
 * 增加@ConfigurationProperties，指定访问前缀
 */
@Controller
@RestController
@ConfigurationProperties(prefix = "manager")
public class DemoController {
    private String name;
    private String password;
    private String hobby;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHobby() {
        return hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 添加@GetMapping注解，添加访问的路径：/get/userinfo 处理get请求
     * 添加@ResponseBody注解， 将方法的返回值作为响应体返回给用户
     * 添加@RequestParam注解，获取请求参数value
     */
    @GetMapping("/get/userinfo")
    @ResponseBody
    public String getUserinfo(@RequestParam(value="nickname") String nickname,@RequestParam(value="age")String age){
        return  "昵称："+ nickname;
    }

    @PostMapping("/login") // 处理post请求
    public String login (){
        return "login success";
    }

    @GetMapping("/get/propvalue")
    @ResponseBody
    public String getPropertiesValue(@Value("${server.port}")String port){ // 读取配置文件属性
        System.out.println("port:"+port);
        System.out.println("name:"+name);
        System.out.println("password:"+password);
        System.out.println("hobby:"+hobby);;
        return "port:" + port+ "name:" + name + "password:"+ password +"hobby:" + hobby;
    }
}
