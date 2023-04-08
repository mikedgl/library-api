package com.mikedgl.livrariaapi.dao;

import com.mikedgl.livrariaapi.domain.PublishingCompany;

import java.util.Optional;

public interface PublishingCompanyDAO {
    public Optional<PublishingCompany> getEntity(Long id);
}
