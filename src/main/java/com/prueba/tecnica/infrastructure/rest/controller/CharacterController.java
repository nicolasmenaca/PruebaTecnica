package com.prueba.tecnica.infrastructure.rest.controller;

import com.prueba.tecnica.application.service.CharacterService;
import com.prueba.tecnica.domain.model.CharacterModel;
import com.prueba.tecnica.infrastructure.constant.MessageOverall;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterDto;
import com.prueba.tecnica.infrastructure.rest.dto.CharacterResponseListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = MessageOverall.PATH_RICKANDMORTY)
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping(value = MessageOverall.CONTEXT_PATH_CHARACTER)
    public CharacterResponseListDto getAllCharacter(){
        return characterService.getAllCharacter();
    }

    @GetMapping(value = MessageOverall.CONTEXT_PATH_CHARACTER + MessageOverall.CONTEXT_PATH_ID)
    public ResponseEntity<CharacterDto> getCharacterById(@PathVariable Integer id) throws Exception {
        CharacterDto characterDto = characterService.getCharacterById(id);
        if (characterDto != null){
            return ResponseEntity.ok(characterDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = MessageOverall.CONTEXT_PATH_CHARACTER)
    public CharacterDto saveCharacter(@RequestBody CharacterModel characterModel){
        return characterService.saveCharacter(characterModel);
    }

    @PutMapping(value = MessageOverall.CONTEXT_PATH_CHARACTER + MessageOverall.CONTEXT_PATH_ID)
    public CharacterDto updateCharacter(@PathVariable Integer id,@RequestBody CharacterModel characterModel){
        return characterService.updateCharacter(id,characterModel);
    }

    @DeleteMapping(value = MessageOverall.CONTEXT_PATH_CHARACTER + MessageOverall.CONTEXT_PATH_ID)
    public void deleteCharacter(@PathVariable Integer id){
        characterService.deleteCharacter(id);
    }

}
