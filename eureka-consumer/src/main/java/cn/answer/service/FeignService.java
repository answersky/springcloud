package cn.answer.service;

import cn.answer.service.impl.FeignHystrixImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by liufeng
 * 2018/12/3
 */
@FeignClient(value = "service-spring-cloud",fallback = FeignHystrixImpl.class)
public interface FeignService {

    @RequestMapping(value = "/springcloud",method = RequestMethod.GET)
    String getInfo(@RequestParam("name") String name);
}
