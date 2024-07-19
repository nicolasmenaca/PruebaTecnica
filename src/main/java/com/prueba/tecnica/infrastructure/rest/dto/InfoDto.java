package com.prueba.tecnica.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InfoDto {

    private Integer count;
    private Integer pages;
    private String next;
    private String prev;

}
