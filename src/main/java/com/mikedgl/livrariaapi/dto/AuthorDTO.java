package com.mikedgl.livrariaapi.dto;

import com.mikedgl.livrariaapi.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    private Long id;
    private String name;

    public AuthorDTO(Author author){
        this.id = author.getId();
        this.name = author.getName();
    }
}
