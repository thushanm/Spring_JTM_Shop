package com.example.springShop.controller;

import com.example.springShop.dto.SupplierDTO;
import com.example.springShop.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService service;


    @PostMapping

    public ResponseEntity<SupplierDTO> supplierSaveData(@RequestBody SupplierDTO supplierDTO) {

        return ResponseEntity.ok(service.saveSupplier(supplierDTO));
    }
    @PostMapping(path = "/saveSup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SupplierDTO> supplierSaveWithImage(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String pNumber,
            @RequestPart("photo") MultipartFile photo) {
        try {
            byte[] imageBytes = photo.getBytes();
            return new ResponseEntity<>(service.saveSupplier(new SupplierDTO(id, name, address, pNumber, imageBytes)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/updateSup/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SupplierDTO> supplierUpdate(@RequestParam("p") MultipartFile p,
                                                      @PathVariable int id, SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            supplierDTO.setId(id);
        }
        try {
            supplierDTO.setSPhoto(p.getBytes());
        } catch (IOException e) {
         e.getMessage();
        }

        return new ResponseEntity<>(service.updateSupplier(supplierDTO), HttpStatus.OK);
    }
    @GetMapping("/getSup/{id}")

    public ResponseEntity<SupplierDTO> searchSupplier(@PathVariable("id") int id){

        return new ResponseEntity<>(service.searchSupplier(id),HttpStatus.OK);


    }
}
