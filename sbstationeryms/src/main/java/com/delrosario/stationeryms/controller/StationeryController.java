package com.delrosario.stationeryms.controller;


import com.delrosario.stationeryms.model.Stationery;
import com.delrosario.stationeryms.service.StationeryService;
import com.delrosario.stationeryms.controller.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class StationeryController {
    Logger logger = LoggerFactory.getLogger(StationeryController.class);

    @Autowired
    private StationeryService stationeryService;

    private final StorageService storageService;

    @Autowired
    public StationeryController(StorageService storageService ){
        this.storageService = storageService;
    }


    @GetMapping("/api/stationery")
    public ResponseEntity<?> listStationery()
    {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;

        try {
            Stationery[] stationeries = stationeryService.getStationery();
            response =  ResponseEntity.ok().headers(headers).body(stationeries);
        }
        catch( Exception ex)
        {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PostMapping("api/stationery")
    public ResponseEntity<?> add(@RequestBody Stationery stationery){
        logger.info("Input >> "+  stationery.toString() );
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Stationery newStationery = stationeryService.create(stationery);
            logger.info("created stationery >> "+  newStationery.toString() );
            response = ResponseEntity.ok(newStationery);
        }
        catch( Exception ex)
        {
            logger.error("Failed to retrieve stationery with id : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PutMapping("api/stationery")
    public ResponseEntity<?> update(@RequestBody Stationery stationery){
        logger.info("Update Input >> "+  stationery.toString() );
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Stationery newStationery = stationeryService.update(stationery);
            response = ResponseEntity.ok(stationery);
        }
        catch( Exception ex)
        {
            logger.error("Failed to retrieve stationery with id : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @GetMapping("api/stationery/{id}")
    public ResponseEntity<?> get(@PathVariable final Integer id){
        logger.info("Input stationery id >> "+  Integer.toString(id));
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Stationery stationery = stationeryService.getStationery(id);
            response = ResponseEntity.ok(stationery);
        }
        catch( Exception ex)
        {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("api/stationery/{id}")
    public ResponseEntity<?> delete(@PathVariable final Integer id){
        logger.info("Input >> "+  Integer.toString(id));
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            stationeryService.delete(id);
            response = ResponseEntity.ok(null);
        }
        catch( Exception ex)
        {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
}
