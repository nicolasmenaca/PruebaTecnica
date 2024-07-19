package com.prueba.tecnica.domain.port;


import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.infrastructure.rest.dto.LocationResponseListDto;

import java.util.List;

public interface LocationPort {
    LocationResponseListDto getAllLocation();
    LocationModel getLocationById(Integer id);
    LocationModel saveLocation(LocationModel locationModel);
    LocationModel updateLocation(Integer id, LocationModel locationModel);
    void deleteLocation(Integer id);
}
