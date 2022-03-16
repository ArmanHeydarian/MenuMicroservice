package com.takeaway.menumicroservice.service;


import com.takeaway.menumicroservice.domain.dto.MenuDto;
import com.takeaway.menumicroservice.domain.dto.ProductUpdateDto;
import com.takeaway.menumicroservice.domain.model.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
@Transactional
public interface IMenuService {

    ResponseEntity<String> addMenu(MenuDto menuDto)throws Exception, MethodArgumentNotValidException;
    ResponseEntity<String> syncMenu(Integer menuId , MenuDto menuDto) throws Exception;
    ResponseEntity<Menu> getMenuById(Integer menuId) throws Exception;
    ResponseEntity<String> updateStock(ProductUpdateDto productUpdateDto) throws Exception;

}
