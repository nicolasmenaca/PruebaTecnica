package com.prueba.tecnica.infrastructure.mapper;

import com.prueba.tecnica.domain.model.CharacterModel;
import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.infrastructure.adapter.entity.CharacterEntity;
import com.prueba.tecnica.infrastructure.adapter.entity.LocationEntity;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterDto;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterResponseListDto;
import com.prueba.tecnica.infrastructure.rest.dto.InfoDto;
import com.prueba.tecnica.infrastructure.rest.dto.LocationDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CharacterMapper {

    public static CharacterEntity modelToCharacterEntity (CharacterModel characterModel){
        LocationEntity locationEntity = LocationMapper.modelToLocationEntity(characterModel.getLocation());

        return CharacterEntity.builder()
                .id(characterModel.getId())
                .name(characterModel.getName())
                .status(characterModel.getStatus())
                .species(characterModel.getSpecies())
                .type(characterModel.getType())
                .gender(characterModel.getGender())
                .location(locationEntity)
                .image(characterModel.getImage())
                .url(characterModel.getUrl())
                .created(characterModel.getCreated())
                .build();
    }

    public static CharacterModel entityToCharacterModel (CharacterEntity characterEntity) {
        LocationModel locationModel = LocationMapper.entityToLocationModel(characterEntity.getLocation());

        return CharacterModel.builder()
                .id(characterEntity.getId())
                .name(characterEntity.getName())
                .status(characterEntity.getStatus())
                .species(characterEntity.getSpecies())
                .type(characterEntity.getType())
                .gender(characterEntity.getGender())
                .location(locationModel)
                .image(characterEntity.getImage())
                .url(characterEntity.getUrl())
                .created(characterEntity.getCreated())
                .build();
    }

    public static CharacterDto entityToCharacterDto (CharacterEntity characterEntity) {
        LocationDto locationDto = LocationMapper.entityToLocationDto(characterEntity.getLocation());

        return CharacterDto.builder()
                .id(characterEntity.getId())
                .name(characterEntity.getName())
                .status(characterEntity.getStatus())
                .species(characterEntity.getSpecies())
                .type(characterEntity.getType())
                .gender(characterEntity.getGender())
                .origin(locationDto)
                .location(locationDto)
                .image(characterEntity.getImage())
                .url(characterEntity.getUrl())
                .created(characterEntity.getCreated())
                .build();
    }

    public static CharacterResponseListDto convertToCharacterResponseListDto(List<CharacterEntity> characterEntities) {
        InfoDto infoDto = InfoDto.builder().count(126).pages(7).next("https://rickandmortyapi.com/api/location?page=2").build();

        return CharacterResponseListDto
                .builder()
                .info(infoDto)
                .results(characterEntities.stream()
                        .map(CharacterMapper::entityToCharacterDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static void updateCharacterEntityFromModel(CharacterModel characterModel, CharacterEntity characterEntity) {
        characterEntity.setName(characterModel.getName());
        characterEntity.setStatus(characterModel.getStatus());
        characterEntity.setSpecies(characterModel.getSpecies());
        characterEntity.setType(characterModel.getType());
        characterEntity.setGender(characterModel.getGender());
        if (Objects.nonNull(characterModel.getLocation())) {
        characterEntity.setLocation(LocationMapper.modelToLocationEntity(characterModel.getLocation()));
        }
        characterEntity.setImage(characterModel.getImage());
        characterEntity.setUrl(characterModel.getUrl());
        characterEntity.setCreated(characterModel.getCreated());

    }

    /*
    public static void updateCharacterEntityFromModel(CharacterModel characterModel, CharacterEntity characterEntity) {
        if (characterModel.getName() != null) {
            characterEntity.setName(characterModel.getName());
        }
        if (characterModel.getStatus() != null) {
            characterEntity.setStatus(characterModel.getStatus());
        }
        if (characterModel.getSpecies() != null) {
            characterEntity.setSpecies(characterModel.getSpecies());
        }
        if (characterModel.getType() != null) {
            characterEntity.setType(characterModel.getType());
        }
        if (characterModel.getGender() != null) {
            characterEntity.setGender(characterModel.getGender());
        }
        if (characterModel.getLocation() != null) {
            characterEntity.setLocation(LocationMapper.modelToLocationEntity(characterModel.getLocation()));
        }
        if (characterModel.getImage() != null) {
            characterEntity.setImage(characterModel.getImage());
        }
        if (characterModel.getUrl() != null) {
            characterEntity.setUrl(characterModel.getUrl());
        }
        if (characterModel.getCreated() != null) {
            characterEntity.setCreated(characterModel.getCreated());
        }
    }
     */
}
