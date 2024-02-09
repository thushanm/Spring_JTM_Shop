package com.example.springShop.service.impl;

import com.example.springShop.dto.UserDTO;
import com.example.springShop.entity.User;
import com.example.springShop.repositary.UserRepository;
import com.example.springShop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
      userRepository.save(modelMapper.map(userDTO, User.class));
      return userDTO;
    }

    @Override
    public UserDTO searchUser(int id) {
    User user = userRepository.findById(id).orElse(null);
    if (user!=null){
        return modelMapper.map(user, UserDTO.class);
    }
    else{
        return null;
    }
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }
}
