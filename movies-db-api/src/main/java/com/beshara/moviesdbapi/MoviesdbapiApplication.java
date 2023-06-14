package com.beshara.moviesdbapi;

import org.apache.ibatis.annotations.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"com.beshara.moviesdbapi.mapper"}, annotationClass = Mapper.class)
public class MoviesdbapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesdbapiApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }
}
