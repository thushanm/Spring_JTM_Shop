package com.example.springShop.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private int id;
    private String name;
    private String address;
    private int number;
}
