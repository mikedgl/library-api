package com.mikedgl.livrariaapi.dao.impl;

import com.mikedgl.livrariaapi.dao.BaseDAO;
import com.mikedgl.livrariaapi.dao.BookDAO;
import com.mikedgl.livrariaapi.domain.*;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private BaseDAO baseDAO;

    @Override
    public ViewBookDTO findById(Long id) {
        CriteriaQuery<ViewBookDTO> cq = baseDAO.getCb().createQuery(ViewBookDTO.class);
        Root<Book> root = cq.from(Book.class);
        Join<Book, Author> authorJoin = root.join("author");
        Join<Book, PublishingCompany> publishingCompanyJoin = root.join("publishingCompany");
        Join<Book, Category> categoryJoin = root.join("category");
        Join<Book, Language> languageJoin = root.join("language");

        cq.select(baseDAO.getCb().construct(ViewBookDTO.class, getSellectionsViewBook(root, authorJoin, publishingCompanyJoin, categoryJoin, languageJoin)))
                .where(baseDAO.getCb().equal(root.get("id"), id));

        return baseDAO.getEm().createQuery(cq).getResultStream().findFirst().orElse(null);
    }

    private Selection[] getSellectionsViewBook(Root<Book> root, Join<Book, Author> authorJoin, Join<Book, PublishingCompany> publishingCompanyJoin,  Join<Book, Category> categoryJoin, Join<Book, Language> languageJoin){
        return new Selection[]{
                root.get("id"),
                root.get("title"),
                root.get("numberOfPages"),
                root.get("isbn"),
                root.get("year"),
                authorJoin.get("name").alias("author"),
                publishingCompanyJoin.get("name").alias("publishingCompany"),
                categoryJoin.get("name").alias("category"),
                languageJoin.get("name").alias("language")
        };
    }

}
