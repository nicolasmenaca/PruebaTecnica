package com.prueba.tecnica.application.service;

import com.prueba.tecnica.domain.model.CharacterModel;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterDto;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterResponseListDto;

public interface CharacterService {

    CharacterResponseListDto getAllCharacter();
    CharacterDto getCharacterById(Integer id) throws Exception;
    CharacterDto saveCharacter(CharacterModel characterModel);
    CharacterDto updateCharacter(Integer id, CharacterModel characterModel);
    void deleteCharacter(Integer id);

}
