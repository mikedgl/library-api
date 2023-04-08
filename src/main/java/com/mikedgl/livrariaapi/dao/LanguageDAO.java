package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.domain.Language;

import java.util.Optional;

public interface LanguageDAO {
    Optional<Language> getEntity(Long id);
}
