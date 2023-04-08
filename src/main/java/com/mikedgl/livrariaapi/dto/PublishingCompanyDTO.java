package com.mikedgl.livrariaapi.dto;

import com.mikedgl.livrariaapi.domain.PublishingCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingCompanyDTO {
    private Long id;
    private String name;
    public PublishingCompanyDTO(PublishingCompany publishingCompany){
        this.id = publishingCompany.getId();
        this.name = publishingCompany.getName();
    }
}
