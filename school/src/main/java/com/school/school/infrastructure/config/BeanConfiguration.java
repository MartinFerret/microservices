package com.school.school.infrastructure.config;

import com.school.school.infrastructure.persistence.mapper.SchoolMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public SchoolMapper schoolMapper(ModelMapper modelMapper){
        return new SchoolMapper(modelMapper);
    }
}
