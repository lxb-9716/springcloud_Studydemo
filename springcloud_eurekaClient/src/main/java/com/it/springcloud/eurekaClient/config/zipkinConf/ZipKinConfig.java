package com.it.springcloud.eurekaClient.config.zipkinConf;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZipKinConfig {
    /*配置zipkin的采样策略*/
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE; //表示持续采样
    }
}
