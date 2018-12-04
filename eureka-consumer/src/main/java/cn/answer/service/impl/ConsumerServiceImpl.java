package cn.answer.service.impl;

import cn.answer.service.ConsumerService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2018/12/3
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private Environment environment;

    @Override
    public String requestInfo() {
        String host=environment.getProperty("request.url");
        return restTemplate.getForObject(host+"?name=ribbon",String.class);
    }
}
