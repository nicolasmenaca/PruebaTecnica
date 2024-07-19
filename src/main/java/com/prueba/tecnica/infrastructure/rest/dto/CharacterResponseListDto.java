package com.prueba.tecnica.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CharacterResponseListDto {
    private InfoDto info;
    private List<CharacterDto> results;
}
