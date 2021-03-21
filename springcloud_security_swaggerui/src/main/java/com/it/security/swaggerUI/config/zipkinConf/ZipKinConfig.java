package com.it.security.swaggerUI.config.zipkinConf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import brave.sampler.Sampler;

@Configuration
public class ZipKinConfig {
    /*配置zipkin的采样策略*/
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE; //表示持续采样
    }
}
