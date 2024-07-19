package com.prueba.tecnica.infrastructure.rest.controller;

import com.prueba.tecnica.application.service.LocationService;
import com.prueba.tecnica.domain.model.LocationModel;
import com.prueba.tecnica.infrastructure.constant.MessageOverall;
import com.prueba.tecnica.infrastructure.rest.dto.LocationResponseListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = MessageOverall.PATH_RICKANDMORTY)
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = MessageOverall.CONTEXT_PATH_LOCATION)
    public LocationResponseListDto getAllLocation(){
        return locationService.getAllLocation();
    }

    @GetMapping(value = MessageOverall.CONTEXT_PATH_LOCATION + MessageOverall.CONTEXT_PATH_ID)
    public ResponseEntity<LocationModel> getLocationById(@PathVariable Integer id){
        LocationModel locationResponse = locationService.getLocationById(id);
        if (locationResponse != null){
            return ResponseEntity.ok(locationResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = MessageOverall.CONTEXT_PATH_LOCATION)
    public LocationModel saveLocation(@RequestBody LocationModel locationModel){
        return locationService.saveLocation(locationModel);
    }

    @PutMapping(value = MessageOverall.CONTEXT_PATH_LOCATION + MessageOverall.CONTEXT_PATH_ID)
    public LocationModel updateLocation(@PathVariable Integer id,@RequestBody LocationModel locationModel){
        return locationService.updateLocation(id,locationModel);
    }

    @DeleteMapping(value = MessageOverall.CONTEXT_PATH_LOCATION + MessageOverall.CONTEXT_PATH_ID)
    public void deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
    }
}
