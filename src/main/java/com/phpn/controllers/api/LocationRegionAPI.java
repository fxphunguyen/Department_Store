package com.phpn.controllers.api;

<<<<<<< HEAD
=======

import com.phpn.dto.localtionRegion.LocationRegionResult;
>>>>>>> huy_dev
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.LocationRegion;
import com.phpn.services.locationRegion.LocationRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> huy_dev
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> huy_dev

@RestController
@RequestMapping("/api/locationRegion")
public class LocationRegionAPI {
<<<<<<< HEAD



    @Autowired
    LocationRegionService locationRegionService;

=======
    @Autowired
     LocationRegionService locationRegionService;
>>>>>>> huy_dev

    @Autowired
    LocationRegionRepository locationRegionRepository;

<<<<<<< HEAD
=======

>>>>>>> huy_dev
    @GetMapping()
    public ResponseEntity<?> findAllLocationReggion(){
        List<LocationRegion>locationRegions =locationRegionRepository.findAll();
   return  new ResponseEntity<>(locationRegions , HttpStatus.OK);

    }
<<<<<<< HEAD



//        LocationRegionResult locationRegion = locationRegionService.findById( id);

//    @GetMapping("/{id}")
//    public LocationRegionResult findLocationRegionByID(@PathVariable Integer id){
//        LocationRegionResult locationRegion = locationRegionService.findById( id);
//       return locationRegion;
//    }
=======
    @GetMapping("/{id}")
    public ResponseEntity<?> findLocationRegionByID(@PathVariable Integer id){
        LocationRegionResult locationRegionResult = locationRegionService.findById(id);
       return new ResponseEntity<>(locationRegionResult, HttpStatus.OK) ;
    }
>>>>>>> huy_dev

}
