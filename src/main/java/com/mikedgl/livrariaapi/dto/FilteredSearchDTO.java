package com.mikedgl.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredSearchDTO implements Serializable {
    private String title;
    private String isbn;
    private Integer year;
    private Long authorId;
    private Long publishingCompanyId;
    private Long categoryId;
    private Long languageId;
}
