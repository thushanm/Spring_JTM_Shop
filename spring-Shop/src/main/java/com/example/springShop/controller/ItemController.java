package com.example.springShop.controller;

import com.example.springShop.dto.ItemDTO;
import com.example.springShop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
@Autowired
    private ItemService itemService;

    @PostMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ItemDTO> saveItem(@RequestParam MultipartFile photo, ItemDTO itemDTO) throws IOException {

        byte[] getBytePhoto = photo.getBytes();
        itemDTO.setItemImg(getBytePhoto);
        return ResponseEntity.ok(itemService.saveItem(itemDTO));

    }
    @PutMapping(value = "/update",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ItemDTO> updateItem(@RequestParam MultipartFile photo,ItemDTO itemDTO) throws IOException {

        byte[] getBytePhoto = photo.getBytes();
        itemDTO.setItemImg(getBytePhoto);
        return ResponseEntity.ok(itemService.updateItem(itemDTO));
    }
    @GetMapping(value = "/search/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ItemDTO> searchItem(@PathVariable int id,ItemDTO itemDTO){

        return new ResponseEntity<>(itemService.searchItem(id),HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")

    public ResponseEntity<ItemDTO> deleteItem(@PathVariable int id,ItemDTO itemDTO){
        itemService.deleteItem(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
