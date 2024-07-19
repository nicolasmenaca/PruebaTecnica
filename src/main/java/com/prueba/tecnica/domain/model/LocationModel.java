package com.prueba.tecnica.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class LocationModel {

    private int id;

    private String name;
    private String type;
    private String dimension;

    private List<String> residents;

    private String url;
    private String created;
}
