package com.example.springShop.service.impl;

import com.example.springShop.dto.ItemDTO;
import com.example.springShop.entity.Item;
import com.example.springShop.repositary.ItemRepository;
import com.example.springShop.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ItemServiceImpl implements ItemService {
    @Autowired
  private ItemRepository itemRepository;
    @Autowired
  private ModelMapper modelMapper;
    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
      itemRepository.save(modelMapper.map(itemDTO, Item.class));
      return itemDTO;

    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {

      itemRepository.save(modelMapper.map(itemDTO, Item.class));
      return itemDTO;
    }

    @Override
    public ItemDTO searchItem(int id) {
        Item item = itemRepository.findById(id).orElse(null);
      if (item != null){
        return modelMapper.map(item, ItemDTO.class);

      }
      else {

        return null;
      }
    }

    @Override
    public void deleteItem(int id) {
    itemRepository.deleteById(id);
    }
}
