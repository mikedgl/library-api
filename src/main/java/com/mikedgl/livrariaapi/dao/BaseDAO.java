package com.mikedgl.livrariaapi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Data
@NoArgsConstructor
@Component
public class BaseDAO {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CriteriaBuilder cb;

}
