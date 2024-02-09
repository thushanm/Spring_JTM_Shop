package com.example.springShop.controller;

import com.example.springShop.dto.UserDTO;
import com.example.springShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getUserName());
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){

        return ResponseEntity.ok(userService.updateUser(userDTO));
    }
    @GetMapping("/search/{id}")
public ResponseEntity<UserDTO> searchUser(@PathVariable int id){
        return new ResponseEntity(userService.searchUser(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable int id){

   userService.deleteUser(id);
return new ResponseEntity<>(null,HttpStatus.OK);

    }
}
