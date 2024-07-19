package com.prueba.tecnica.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CharacterDto {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationDto origin;
    private LocationDto location;
    private String image;
    //private List<String> episode;
    private String url;
    private String created;
}
