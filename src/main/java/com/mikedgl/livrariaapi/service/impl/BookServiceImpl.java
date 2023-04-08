package com.mikedgl.livrariaapi.service.impl;

import com.mikedgl.livrariaapi.dao.BookDAO;
import com.mikedgl.livrariaapi.domain.*;
import com.mikedgl.livrariaapi.dto.BookDTO;
import com.mikedgl.livrariaapi.dto.FilteredSearchDTO;
import com.mikedgl.livrariaapi.dto.SaveBookDTO;
import com.mikedgl.livrariaapi.dto.ViewBookDTO;
import com.mikedgl.livrariaapi.exception.BusinessException;
import com.mikedgl.livrariaapi.exception.ResourceNotFound;
import com.mikedgl.livrariaapi.service.*;
import com.mikedgl.livrariaapi.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublishingCompanyService publishingCompanyService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LanguageService languageService;

    public ViewBookDTO findById(Long id){
        ViewBookDTO book = bookDAO.findById(id);
        if(Objects.isNull(book)) throw new ResourceNotFound(Messages.BOOK_NOT_FOUND);
        return book;
    }

    @Override
    public List<ViewBookDTO> filteredSearch(FilteredSearchDTO filter) {
        return bookDAO.filteredSearch(filter);
    }

    @Override
    public BookDTO saveBook(SaveBookDTO bookDTO) {
        if(bookDAO.findBookByIsbn(bookDTO.getIsbn()).isPresent()){
            throw new BusinessException(Messages.ISBN_ALREADY_EXISTS);
        }
        Author author = authorService.getEntity(bookDTO.getAuthorId());
        PublishingCompany publishingCompany = publishingCompanyService.getEntity(bookDTO.getPublishingCompanyId());
        Category category = categoryService.getEntity(bookDTO.getCategoryId());
        Language language = languageService.getEntity(bookDTO.getLanguageId());

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setNumberOfPages(bookDTO.getNumberOfPages());
        book.setIsbn(bookDTO.getIsbn());
        book.setYear(bookDTO.getYear());
        book.setAuthor(author);
        book.setPublishingCompany(publishingCompany);
        book.setCategory(category);
        book.setLanguage(language);

        bookDAO.save(book);

        return new BookDTO(book);
    }


}
