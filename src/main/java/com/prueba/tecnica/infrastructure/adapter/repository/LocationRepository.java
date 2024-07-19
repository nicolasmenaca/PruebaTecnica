package com.prueba.tecnica.infrastructure.adapter.repository;

import com.prueba.tecnica.infrastructure.adapter.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Integer> {
}
