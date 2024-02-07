package com.example.springShop.service;

import com.example.springShop.dto.ItemDTO;

public interface ItemService {
    ItemDTO saveItem(ItemDTO itemDTO);
    ItemDTO updateItem(ItemDTO itemDTO);
    ItemDTO searchItem(int id);
void deleteItem(int id);


}
