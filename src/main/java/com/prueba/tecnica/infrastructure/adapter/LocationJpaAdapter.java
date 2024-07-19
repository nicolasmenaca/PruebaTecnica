package com.prueba.tecnica.infrastructure.adapter;

import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.domain.port.LocationPort;
import com.prueba.tecnica.infrastructure.adapter.entity.LocationEntity;
import com.prueba.tecnica.infrastructure.adapter.repository.LocationRepository;
import com.prueba.tecnica.infrastructure.mapper.LocationMapper;
import com.prueba.tecnica.infrastructure.rest.dto.LocationResponseListDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocationJpaAdapter implements LocationPort {

    private final LocationRepository locationRepository;

    public LocationJpaAdapter(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationResponseListDto getAllLocation() {
        return LocationMapper.convertToLocationResponseListDto(locationRepository.findAll());
    }

    @Override
    public LocationModel getLocationById(Integer id) {
        Optional<LocationEntity> locationEntity = locationRepository.findById(id);
        if (locationEntity.isPresent()){
            return LocationMapper.entityToLocationModel(locationEntity.get());
        }
        return null;
    }

    @Override
    public LocationModel saveLocation(LocationModel locationModel) {
        LocationEntity location = LocationMapper.modelToLocationEntity(locationModel);
        LocationEntity locationSave = locationRepository.save(location);
        return LocationMapper.entityToLocationModel(locationSave);
    }

    @Override
    public LocationModel updateLocation(Integer id, LocationModel locationModel) {
        Optional<LocationEntity> locationEntityOptional = locationRepository.findById(id);
        if (locationEntityOptional.isPresent()){
            LocationEntity locationEntity = locationEntityOptional.get();
            LocationMapper.updateLocationEntityFromModel(locationModel, locationEntity);
            LocationEntity updatedLocationEntity = locationRepository.save(locationEntity);
            return LocationMapper.entityToLocationModel(updatedLocationEntity);
        }
        return null;
    }

    @Override
    public void deleteLocation(Integer id) {
        locationRepository.deleteById(id);
    }
}
