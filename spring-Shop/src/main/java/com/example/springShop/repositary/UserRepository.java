package com.example.springShop.repositary;

import com.example.springShop.dto.UserDTO;
import com.example.springShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
