package com.prueba.tecnica.application.UseCase;

import com.prueba.tecnica.application.service.LocationService;
import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.domain.port.LocationPort;
import com.prueba.tecnica.infrastructure.rest.dto.LocationResponseListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LocationUseCase implements LocationService {

    private final LocationPort locationPort;

    @Override
    public LocationResponseListDto getAllLocation() {
        return locationPort.getAllLocation();
    }

    @Override
    public LocationModel getLocationById(Integer id) {
        return locationPort.getLocationById(id);
    }

    @Override
    public LocationModel saveLocation(LocationModel locationModel) {
        return locationPort.saveLocation(locationModel);
    }

    @Override
    public LocationModel updateLocation(Integer id, LocationModel locationModel) {
        return locationPort.updateLocation(id, locationModel);
    }

    @Override
    public void deleteLocation(Integer id) {
        locationPort.deleteLocation(id);
    }
}
