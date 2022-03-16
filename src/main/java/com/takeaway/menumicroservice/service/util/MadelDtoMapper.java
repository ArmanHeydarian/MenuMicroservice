package com.takeaway.menumicroservice.service.util;

import com.takeaway.menumicroservice.domain.dto.MenuDto;
import com.takeaway.menumicroservice.domain.model.Menu;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.Date;

public  class  MadelDtoMapper {

    public static Menu convertToEntity(MenuDto menuDto) throws ParseException {
        ModelMapper modelMapper =new ModelMapper();
        Menu menu = modelMapper.map(menuDto, Menu.class);
        menu.setCreateDate(new Date());
        menu.setStatus(true);
        menu.getResturants().forEach(item -> item.setId(0));
        return menu;
    }
}
