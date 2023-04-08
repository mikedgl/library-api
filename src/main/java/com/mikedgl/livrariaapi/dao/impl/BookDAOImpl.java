package com.mikedgl.livrariaapi.dao.impl;

import com.mikedgl.livrariaapi.dao.BaseDAO;
import com.mikedgl.livrariaapi.dao.BookDAO;
import com.mikedgl.livrariaapi.domain.*;
import com.mikedgl.livrariaapi.dto.FilteredSearchDTO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

    @Override
    public ViewBookDTO findById(Long id) {
        CriteriaQuery<ViewBookDTO> cq = getCb().createQuery(ViewBookDTO.class);
        Root<Book> root = cq.from(Book.class);
        Join<Book, Author> authorJoin = root.join("author");
        Join<Book, PublishingCompany> publishingCompanyJoin = root.join("publishingCompany");
        Join<Book, Category> categoryJoin = root.join("category");
        Join<Book, Language> languageJoin = root.join("language");

        cq.select(getCb().construct(ViewBookDTO.class, getSellectionsViewBook(root, authorJoin, publishingCompanyJoin, categoryJoin, languageJoin)))
                .where(getCb().equal(root.get("id"), id));

        return getEm().createQuery(cq).getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<ViewBookDTO> filteredSearch(FilteredSearchDTO filter) {
        CriteriaQuery<ViewBookDTO> cq = getCb().createQuery(ViewBookDTO.class);
        Root<Book> root = cq.from(Book.class);
        Join<Book, Author> authorJoin = root.join("author");
        Join<Book, PublishingCompany> publishingCompanyJoin = root.join("publishingCompany");
        Join<Book, Category> categoryJoin = root.join("category");
        Join<Book, Language> languageJoin = root.join("language");

        List<Predicate> predicates = new ArrayList<>();

        // TODO: 06/04/2023 Refatorar filtro de titulo para ignorar case e acentos
        if(StringUtils.isNotBlank(filter.getTitle())){
            predicates.add(getCb().like(root.get("title"), "%" + filter.getTitle() + "%"));
        }
        if(StringUtils.isNotBlank(filter.getIsbn())){
            predicates.add(getCb().equal(root.get("isbn"), filter.getIsbn()));
        }
        if(Objects.nonNull(filter.getYear())){
            predicates.add(getCb().equal(root.get("year"), filter.getYear()));
        }
        if(Objects.nonNull(filter.getAuthorId())){
            predicates.add(getCb().equal(root.get("author"), filter.getAuthorId()));
        }
        if(Objects.nonNull(filter.getPublishingCompanyId())){
            predicates.add(getCb().equal(root.get("publishingCompany"), filter.getPublishingCompanyId()));
        }
        if(Objects.nonNull(filter.getCategoryId())){
            predicates.add(getCb().equal(root.get("category"), filter.getCategoryId()));
        }
        if(Objects.nonNull(filter.getLanguageId())){
            predicates.add(getCb().equal(root.get("language"), filter.getLanguageId()));
        }

        cq.select(getCb().construct(ViewBookDTO.class, getSellectionsViewBook(root, authorJoin, publishingCompanyJoin, categoryJoin, languageJoin)))
                .orderBy(getCb().asc(root.get("title")))
                .where(predicates.toArray(predicates.toArray(new Predicate[0])));

        return getEm().createQuery(cq).getResultList();
    }

    public Optional<Book> findBookByIsbn(String isbn){
        CriteriaQuery<Book> cq = getCb().createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);

        cq.where(getCb().equal(root.get("isbn"), isbn));

        return getEm().createQuery(cq).getResultStream().findFirst();
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
