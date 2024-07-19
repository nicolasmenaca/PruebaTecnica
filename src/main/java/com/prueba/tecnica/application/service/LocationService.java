package com.prueba.tecnica.application.service;

import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.infrastructure.rest.dto.LocationResponseListDto;


public interface LocationService {

    LocationResponseListDto getAllLocation();
    LocationModel getLocationById(Integer id);
    LocationModel saveLocation(LocationModel locationModel);
    LocationModel updateLocation(Integer id, LocationModel locationModel);
    void deleteLocation(Integer id);
}
