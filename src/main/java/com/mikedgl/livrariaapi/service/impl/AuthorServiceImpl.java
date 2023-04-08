package com.mikedgl.livrariaapi.service.impl;

import com.mikedgl.livrariaapi.dao.AuthorDAO;
import com.mikedgl.livrariaapi.domain.Author;
import com.mikedgl.livrariaapi.dto.AuthorDTO;
import com.mikedgl.livrariaapi.exception.ResourceNotFound;
import com.mikedgl.livrariaapi.service.AuthorService;
import com.mikedgl.livrariaapi.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public AuthorDTO findById(Long id) {
        AuthorDTO authorDTO = authorDAO.findById(id).orElseThrow(() -> new ResourceNotFound(Messages.AUTHOR_NOT_FOUND));
        return authorDTO;
    }

    @Override
    public Author getEntity(Long id) {
        return authorDAO.getEntity(id).orElseThrow(() -> new ResourceNotFound(Messages.AUTHOR_NOT_FOUND));
    }
}
