package com.phpn.controllers.api;

import com.phpn.dto.item.ItemRResult;
import com.phpn.services.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemAPI {

    @Autowired
    ItemService itemService;

    @GetMapping("/variants")
    public ResponseEntity<?> findAll() {
        List<ItemRResult> itemResults = itemService.findAll();

        return new ResponseEntity<>(itemResults, HttpStatus.OK);
    }

}
