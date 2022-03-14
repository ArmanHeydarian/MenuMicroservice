package com.takeaway.menumicroservice.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.takeaway.menumicroservice.ExceptionHandler.RecordNotFoundException;
import com.takeaway.menumicroservice.domain.dto.MenuDto;
import com.takeaway.menumicroservice.domain.model.Menu;
import com.takeaway.menumicroservice.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    public ResponseEntity<String> addMenu(MenuDto menuDto) throws Exception
    {
        Menu menu = jacksonObjectMapper.convertValue(menuDto, new TypeReference<Menu>() {});
        menuRepository.save(menu);
        return ResponseEntity.ok("Menu Saved Successfully");
    }

    public Menu getMenuByResturantId(int resturantId)  throws Exception , RecordNotFoundException
    {
     Optional<Menu> optionalMenu = menuRepository.findById(resturantId);
     if (optionalMenu.isPresent())
     {
         return optionalMenu.get();
     }
     else
     {
         throw new RecordNotFoundException("Record not found");
     }

    }


}
