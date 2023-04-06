package com.mikedgl.livrariaapi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class BaseDAO {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CriteriaBuilder cb;
}
