package com.mikedgl.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBookDTO {
    private Long id;
    private String title;
    private Integer numberOfPages;
    private String isbn;
    private Integer year;
    private String author;
    private String publishingCompany;
    private String category;
    private String language;
}
