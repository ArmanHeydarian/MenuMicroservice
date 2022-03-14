package com.takeaway.menumicroservice.api;

import com.takeaway.menumicroservice.ExceptionHandler.RecordNotFoundException;
import com.takeaway.menumicroservice.domain.dto.MenuDto;
import com.takeaway.menumicroservice.domain.model.Menu;
import com.takeaway.menumicroservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // This Method is For Both Adding and Updating (Syncing) Menus from Resturants
    @PostMapping(path = "/sync")
    public ResponseEntity<String> syncMenu(@RequestBody MenuDto menuDto) throws Exception , MethodArgumentNotValidException {
        return menuService.syncMenu(menuDto);
    }

    // This Method is Get Menus from TakeAway.com
    @GetMapping(path = "/get" , produces = {"application/json"})
    public ResponseEntity<Menu> getMenuByResturantId(@RequestParam(value = "resturantId"  ) Integer resturantId) throws Exception , RecordNotFoundException {
        Menu menu = menuService.getMenuByResturantId(resturantId);
        return  ResponseEntity.ok().body(menu);

    }

}
