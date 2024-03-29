package com.mikedgl.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBookDTO implements Serializable {
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
