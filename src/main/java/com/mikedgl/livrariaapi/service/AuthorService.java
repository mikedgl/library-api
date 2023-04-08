package com.mikedgl.livrariaapi.service;

import com.mikedgl.livrariaapi.domain.Author;
import com.mikedgl.livrariaapi.dto.AuthorDTO;

public interface AuthorService {
    AuthorDTO findById(Long id);
    Author getEntity(Long id);
}
