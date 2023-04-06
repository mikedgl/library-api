package com.mikedgl.livrariaapi.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Autowired
    private EntityManager em;
    @Bean
    public CriteriaBuilder createCriteriaBuilder(){
        return em.getCriteriaBuilder();
    }

}
