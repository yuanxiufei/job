package com.reginyuan.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 增加@Controller注解，标识为该类为控制器组件
 */
@Controller
public class DemoController {
    /**
     * 添加@GetMapping注解，添加访问的路径：/get/userinfo 处理get请求
     * 添加@ResponseBody注解， 将方法的返回值作为响应体返回给用户
     * 添加@RequestParam注解，获取请求参数value
     * @param nickname
     * @return
     */
    @GetMapping("/get/userinfo")
    @ResponseBody
    public String getUserinfo(@RequestParam(value="nickname") String nickname){
        return  "昵称："+ nickname;
    }
}
