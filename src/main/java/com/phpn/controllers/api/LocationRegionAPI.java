package com.phpn.controllers.api;


import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.LocationRegion;
import com.phpn.services.locationRegion.LocationRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locationRegion")
public class LocationRegionAPI {



    @Autowired
    LocationRegionService locationRegionService;

    @Autowired
    LocationRegionRepository locationRegionRepository;

    @GetMapping()
    public ResponseEntity<?> findAllLocationReggion(){
        List<LocationRegion>locationRegions =locationRegionRepository.findAll();
   return  new ResponseEntity<>(locationRegions , HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findLocationRegionByID(@PathVariable Integer id){
        LocationRegionResult locationRegionResult = locationRegionService.findById(id);
       return new ResponseEntity<>(locationRegionResult, HttpStatus.OK) ;
    }

}
