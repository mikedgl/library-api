package com.mikedgl.livrariaapi.service.impl;

import com.mikedgl.livrariaapi.dao.LanguageDAO;
import com.mikedgl.livrariaapi.domain.Language;
import com.mikedgl.livrariaapi.exception.ResourceNotFound;
import com.mikedgl.livrariaapi.service.LanguageService;
import com.mikedgl.livrariaapi.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDAO languageDAO;

    @Override
    public Language getEntity(Long id) {
        return languageDAO.getEntity(id).orElseThrow(() -> new ResourceNotFound(Messages.LANGUAGE_NOT_FOUND));
    }
}
