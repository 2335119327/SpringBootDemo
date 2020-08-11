package com.dong.secrity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author dong
 * @date 2020/8/11 10:23
 */
@Controller
public class IndexController {

    private final String PREFIX = "pages/";

    /**
     * 初始页面
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "welcome";
    }

    /**
     * 登录页
     * @return
     */
    @GetMapping("/userlogin")
    public String login(){
        return PREFIX + "login";
    }

    /**
     * level1页面
     * @param path
     * @return
     */
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path){
        return PREFIX + "level1/" + path;
    }


    /**
     * level2页面
     * @param path
     * @return
     */
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX + "level2/" + path;
    }

    /**
     * level3页面
     * @param path
     * @return
     */
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path){
        return PREFIX + "level3/" + path;
    }
}
