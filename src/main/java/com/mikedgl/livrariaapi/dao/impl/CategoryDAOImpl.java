package com.mikedgl.livrariaapi.dao.impl;

import com.mikedgl.livrariaapi.dao.BaseDAO;
import com.mikedgl.livrariaapi.dao.CategoryDAO;
import com.mikedgl.livrariaapi.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryDAOImpl extends BaseDAO<Category> implements CategoryDAO {

    @Override
    public Optional<Category> getEntity(Long id) {
        return Optional.ofNullable(getEm().find(Category.class, id));
    }
}
