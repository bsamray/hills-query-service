package com.exercise.tech.hills.config;

import com.exercise.tech.hills.service.HillInfoDataSource;
import com.exercise.tech.hills.service.ReferenceDataLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class AppConfiguration {

    @Resource
    private ReferenceDataLoader referenceDataLoader;

    @Bean
    public HillInfoDataSource hillInfoDataSource() {
        return new HillInfoDataSource(referenceDataLoader.load());
    }

}
