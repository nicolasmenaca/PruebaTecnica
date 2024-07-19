package com.prueba.tecnica.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LocationDto {

    private String name;
    private String url;

}
