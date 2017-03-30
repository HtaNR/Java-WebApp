/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Item;
import com.hatta.webapp.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    public List<Item> getItems(){
        return itemRepository.findAll(new PageRequest(0, 20, Sort.Direction.DESC,"publishDate")).getContent();
    }
}
