package com.prueba.tecnica.infrastructure.rest.dto;

import com.prueba.tecnica.domain.model.LocationModel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class LocationResponseListDto {
    private InfoDto info;
    private List<LocationModel> results;
}
