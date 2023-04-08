package com.mikedgl.livrariaapi.dao.impl;

import com.mikedgl.livrariaapi.dao.AuthorDAO;
import com.mikedgl.livrariaapi.dao.BaseDAO;
import com.mikedgl.livrariaapi.domain.Author;
import com.mikedgl.livrariaapi.dto.AuthorDTO;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthorDAOImpl extends BaseDAO<Author> implements AuthorDAO {
    public Optional<AuthorDTO> findById(Long id){
        CriteriaQuery<AuthorDTO> cq = getCb().createQuery(AuthorDTO.class);
        Root<Author> root = cq.from(Author.class);

        cq.where(getCb().equal(root.get("id"), id));

        return getEm().createQuery(cq).getResultStream().findFirst();
    }

    @Override
    public Optional<Author> getEntity(Long id) {
        return Optional.ofNullable(getEm().find(Author.class, id));
    }


}
