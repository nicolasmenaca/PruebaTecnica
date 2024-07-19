package com.prueba.tecnica.application.UseCase;

import com.prueba.tecnica.application.service.CharacterService;
import com.prueba.tecnica.domain.model.CharacterModel;
import com.prueba.tecnica.domain.port.CharacterPort;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterDto;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterResponseListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CharacterUseCase implements CharacterService {

    private final CharacterPort characterPort;

    @Override
    public CharacterResponseListDto getAllCharacter() {
        return characterPort.getAllCharacter();
    }

    @Override
    public CharacterDto getCharacterById(Integer id) throws Exception {
        return characterPort.getCharacterById(id);
    }

    @Override
    public CharacterDto saveCharacter(CharacterModel characterModel) {
        return characterPort.saveCharacter(characterModel);
    }

    @Override
    public CharacterDto updateCharacter(Integer id, CharacterModel characterModel) {
        return characterPort.updateCharacter(id, characterModel);
    }

    @Override
    public void deleteCharacter(Integer id) {
        characterPort.deleteCharacter(id);
    }
}
