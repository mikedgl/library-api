package com.mikedgl.livrariaapi.dao.impl;

import com.mikedgl.livrariaapi.dao.BaseDAO;
import com.mikedgl.livrariaapi.dao.PublishingCompanyDAO;
import com.mikedgl.livrariaapi.domain.PublishingCompany;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PublishingCompanyDAOImpl extends BaseDAO<PublishingCompany> implements PublishingCompanyDAO {
    @Override
    public Optional<PublishingCompany> getEntity(Long id) {
        return Optional.ofNullable(getEm().find(PublishingCompany.class, id));
    }
}
