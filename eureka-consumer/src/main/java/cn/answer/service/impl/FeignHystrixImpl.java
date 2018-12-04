package cn.answer.service.impl;

import cn.answer.service.FeignService;
import org.springframework.stereotype.Service;

/**
 * created by liufeng
 * 2018/12/3
 */
@Service
public class FeignHystrixImpl implements FeignService {
    @Override
    public String getInfo(String name) {
        return "sorry "+name+",i am error";
    }
}
