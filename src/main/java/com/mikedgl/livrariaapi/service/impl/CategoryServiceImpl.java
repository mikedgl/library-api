package com.mikedgl.livrariaapi.service.impl;

import com.mikedgl.livrariaapi.dao.CategoryDAO;
import com.mikedgl.livrariaapi.domain.Category;
import com.mikedgl.livrariaapi.exception.ResourceNotFound;
import com.mikedgl.livrariaapi.service.CategoryService;
import com.mikedgl.livrariaapi.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;


    @Override
    public Category getEntity(Long id) {
        return categoryDAO.getEntity(id).orElseThrow(() -> new ResourceNotFound(Messages.CATEGORY_NOT_FOUND));
    }
}
