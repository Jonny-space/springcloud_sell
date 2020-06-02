package com.springcloud.orderconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:57 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class RibbonConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public IRule ribbonRandomRule() {
        return new WeightedResponseTimeRule();
    }

}
