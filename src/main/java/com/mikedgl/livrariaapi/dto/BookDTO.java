package com.mikedgl.livrariaapi.dto;

import com.mikedgl.livrariaapi.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO implements Serializable {
    private Long id;
    private String title;
    private Integer numberOfPages;
    private String isbn;
    private Integer year;
    private AuthorDTO author;
    private PublishingCompanyDTO publishingCompany;
    private CategoryDTO category;
    private LanguageDTO language;

    public BookDTO(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.year = book.getYear();
        this.author = new AuthorDTO(book.getAuthor());
        this.publishingCompany = new PublishingCompanyDTO(book.getPublishingCompany());
        this.category = new CategoryDTO(book.getCategory());
        this.language = new LanguageDTO(book.getLanguage());
    }
}
