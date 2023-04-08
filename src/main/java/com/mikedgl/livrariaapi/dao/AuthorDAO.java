package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.domain.Author;
import com.mikedgl.livrariaapi.dto.AuthorDTO;

import java.util.Optional;

public interface AuthorDAO {
    Optional<AuthorDTO> findById(Long id);
    Optional<Author> getEntity(Long id);
}
