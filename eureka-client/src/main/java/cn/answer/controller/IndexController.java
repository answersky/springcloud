package cn.answer.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2018/12/3
 */
@RestController
public class IndexController {
    @Resource
    private Environment environment;

    @RequestMapping("/springcloud")
    public String index(String name){
        String port=environment.getProperty("server.port");
        return "hi "+name+",i am from port:" +port;
    }

}
