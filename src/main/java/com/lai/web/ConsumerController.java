package com.lai.web;

import com.lai.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lailai on 2017/9/22.
 * Ribbon中引入Hystrix
 * 在Spring Cloud中使用了Hystrix 来实现断路器的功能
 * 在分布式架构中,当某个服务单元发生故障（类似用电器发生短路）之后，通过断路器的故障监控（类似熔断保险丝），
 * 向调用方返回一个错误响应，而不是长时间的等待。这样就不会使得线程因调用故障服务被长时间占用不释放，
 * 避免了故障在分布式系统中的蔓延
 * Hystrix该框架目标在于通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
 * Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能
 */
@RestController
public class ConsumerController {

    /**
     * 直接使用ribbon实现调用服务
     */
//    @Autowired
//    RestTemplate restTemplate;

    //将服务调用放到service中，改造原来的服务消费方式
    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        //return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20",String.class).getBody();
        return computeService.addService();
    }


}
