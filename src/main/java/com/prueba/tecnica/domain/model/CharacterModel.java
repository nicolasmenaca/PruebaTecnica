package com.prueba.tecnica.domain.model;


import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterModel {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationModel origin;
    private LocationModel location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;


}
