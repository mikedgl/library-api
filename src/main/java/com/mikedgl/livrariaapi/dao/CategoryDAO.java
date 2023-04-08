package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.domain.Category;

import java.util.Optional;

public interface CategoryDAO {
    Optional<Category> getEntity(Long id);
}
