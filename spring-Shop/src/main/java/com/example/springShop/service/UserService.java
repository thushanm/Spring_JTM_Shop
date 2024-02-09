package com.example.springShop.service;

import com.example.springShop.dto.UserDTO;
import com.example.springShop.entity.User;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO searchUser(int id);
    void deleteUser(int id);

}
