package com.example.springShop.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;
        private String userName;
        private String userEmail;
        private String userPwd;

}
