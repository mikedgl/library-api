package com.mikedgl.livrariaapi.dto;

import com.mikedgl.livrariaapi.domain.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDTO {
    private Long id;
    private String name;

    public LanguageDTO(Language language){
        this.id = language.getId();
        this.name = language.getName();
    }
}
