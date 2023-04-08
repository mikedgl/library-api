package com.mikedgl.livrariaapi.service.impl;

import com.mikedgl.livrariaapi.dao.PublishingCompanyDAO;
import com.mikedgl.livrariaapi.domain.PublishingCompany;
import com.mikedgl.livrariaapi.exception.ResourceNotFound;
import com.mikedgl.livrariaapi.service.PublishingCompanyService;
import com.mikedgl.livrariaapi.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingCompanyServiceImpl implements PublishingCompanyService {

    @Autowired
    private PublishingCompanyDAO publishingCompanyDAO;

    @Override
    public PublishingCompany getEntity(Long id) {
        return publishingCompanyDAO.getEntity(id).orElseThrow(() -> new ResourceNotFound(Messages.PUBLISHING_COMPANY_NOT_FOUND));
    }
}
