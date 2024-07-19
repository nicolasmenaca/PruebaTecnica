package com.prueba.tecnica.infrastructure.adapter.repository;

import com.prueba.tecnica.infrastructure.adapter.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
}
