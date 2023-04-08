package com.mikedgl.livrariaapi.dao.impl;

import com.mikedgl.livrariaapi.dao.BaseDAO;
import com.mikedgl.livrariaapi.dao.LanguageDAO;
import com.mikedgl.livrariaapi.domain.Language;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LanguageDAOImpl extends BaseDAO<Language> implements LanguageDAO {
    @Override
    public Optional<Language> getEntity(Long id) {
        return Optional.ofNullable(getEm().find(Language.class, id));
    }
}
