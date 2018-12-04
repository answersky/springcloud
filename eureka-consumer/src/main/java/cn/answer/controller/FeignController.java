package cn.answer.controller;

/**
 * created by liufeng
 * 2018/12/3
 */

import cn.answer.service.ConsumerService;
import cn.answer.service.FeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api-feign")
public class FeignController {
    @Resource
    private FeignService feignService;

    @RequestMapping("/feign")
    public String feign(){
        return feignService.getInfo("feign");
    }
}
