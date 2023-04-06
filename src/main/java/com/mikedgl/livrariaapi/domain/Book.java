package com.mikedgl.livrariaapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false, name = "release_year")
    private Integer year;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Author author;
    @ManyToOne
    @JoinColumn(nullable = false, name = "publishing_company_id")
    private PublishingCompany publishingCompany;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Language language;


}
