package com.prueba.tecnica.infrastructure.mapper;

import com.prueba.tecnica.domain.model.CharacterModel;
import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.infrastructure.adapter.entity.CharacterEntity;
import com.prueba.tecnica.infrastructure.adapter.entity.LocationEntity;
import com.prueba.tecnica.infrastructure.rest.dto.InfoDto;
import com.prueba.tecnica.infrastructure.rest.dto.LocationDto;
import com.prueba.tecnica.infrastructure.rest.dto.LocationResponseListDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LocationMapper {

    public static LocationEntity modelToLocationEntity(LocationModel locationModel){
        return LocationEntity.builder()
                .id(locationModel.getId())
                .name(locationModel.getName())
                .type(locationModel.getType())
                .dimension(locationModel.getDimension())
                .residents(locationModel.getResidents())
                .url(locationModel.getUrl())
                .created(locationModel.getCreated())
                .build();
    }

    public static LocationModel entityToLocationModel(LocationEntity locationEntity){
        return LocationModel.builder()
                .id(locationEntity.getId())
                .name(locationEntity.getName())
                .type(locationEntity.getType())
                .dimension(locationEntity.getDimension())
                .residents(locationEntity.getResidents())
                .url(locationEntity.getUrl())
                .created(locationEntity.getCreated())
                .build();
    }

    public static LocationDto entityToLocationDto(LocationEntity locationEntity){
        return LocationDto.builder()
                .name(locationEntity.getName())
                .url(locationEntity.getUrl())
                .build();
    }


    public static LocationResponseListDto convertToLocationResponseListDto(List<LocationEntity> locationEntities) {
        InfoDto infoDto = InfoDto.builder().count(126).pages(7).next("https://rickandmortyapi.com/api/location?page=2").build();

        return LocationResponseListDto
                .builder()
                .info(infoDto)
                .results(locationEntities.stream()
                        .map(LocationMapper::entityToLocationModel)
                        .collect(Collectors.toList()))
                .build();

    }

    public static void updateLocationEntityFromModel(LocationModel locationModel, LocationEntity locationEntity) {
        locationEntity.setName(locationModel.getName());
        locationEntity.setType(locationModel.getType());
        locationEntity.setDimension(locationModel.getDimension());
        locationEntity.setUrl(locationModel.getUrl());
        locationEntity.setCreated(locationModel.getCreated());
    }


}
