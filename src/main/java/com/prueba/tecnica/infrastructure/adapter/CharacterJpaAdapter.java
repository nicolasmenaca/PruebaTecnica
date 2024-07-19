package com.prueba.tecnica.infrastructure.adapter;

import com.prueba.tecnica.domain.model.CharacterModel;
import com.prueba.tecnica.domain.port.CharacterPort;
import com.prueba.tecnica.infrastructure.adapter.entity.CharacterEntity;
import com.prueba.tecnica.infrastructure.adapter.repository.CharacterRepository;
import com.prueba.tecnica.infrastructure.mapper.CharacterMapper;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterDto;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterResponseListDto;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public class CharacterJpaAdapter implements CharacterPort {

    private final CharacterRepository characterRepository;

    public CharacterJpaAdapter(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public CharacterResponseListDto getAllCharacter() {
        return CharacterMapper.convertToCharacterResponseListDto(characterRepository.findAll());
    }

    @Override
    public CharacterDto getCharacterById(Integer id) throws Exception {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        if (characterEntity.isEmpty()){
            return null;
        }
        return CharacterMapper.entityToCharacterDto(characterEntity.get());

    }

    @Override
    public CharacterDto saveCharacter(CharacterModel characterModel) {
        if(Objects.nonNull(characterModel.getLocation())){
            CharacterEntity character = CharacterMapper.modelToCharacterEntity(characterModel);
            CharacterEntity characterSave = characterRepository.save(character);
            return CharacterMapper.entityToCharacterDto(characterSave);
        }
        return null;
    }

    @Override
    public CharacterDto updateCharacter(Integer id, CharacterModel characterModel) {
        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(id);
        if (characterEntityOptional.isPresent()){
            CharacterEntity characterEntity = characterEntityOptional.get();
            CharacterMapper.updateCharacterEntityFromModel(characterModel, characterEntity);
            CharacterEntity updatedCharacterEntity = characterRepository.save(characterEntity);
            return CharacterMapper.entityToCharacterDto(updatedCharacterEntity);
        }
        return null;
    }

    @Override
    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }
}
