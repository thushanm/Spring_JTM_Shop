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

@RestController
@RequestMapping("/suplier")
public class SupplierController {
    @Autowired
    private SupplierService service;


    @PostMapping

    public ResponseEntity<SupplierDTO> supplierSaveData(@RequestBody SupplierDTO supplierDTO) {

        return ResponseEntity.ok(service.saveSupplier(supplierDTO));
    }
    @PostMapping(path = "/s", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SupplierDTO> supplierSaveWithImage(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String pNumber,
            @RequestPart("s") MultipartFile s) {
        try {
            byte[] imageBytes = s.getBytes();
            return new ResponseEntity<>(service.saveSupplier(new SupplierDTO(id, name, address, pNumber, imageBytes)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
