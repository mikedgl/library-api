package com.mikedgl.livrariaapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookDTO implements Serializable {
    @NotBlank
    private String title;
    @NotNull
    private Integer numberOfPages;
    @NotBlank
    private String isbn;
    @NotNull
    private Integer year;
    @NotNull
    private Long authorId;
    @NotNull
    private Long publishingCompanyId;
    @NotNull
    private Long categoryId;
    @NotNull
    private Long languageId;
}
