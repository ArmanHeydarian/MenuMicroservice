package com.takeaway.menumicroservice.api;

import com.takeaway.menumicroservice.ExceptionHandler.RecordNotFoundException;
import com.takeaway.menumicroservice.domain.dto.MenuDto;
import com.takeaway.menumicroservice.domain.dto.ProductUpdateDto;
import com.takeaway.menumicroservice.domain.model.Menu;
import com.takeaway.menumicroservice.repository.ProductSizeRepository;
import com.takeaway.menumicroservice.service.IMenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/api/menu")
public class MenuController {

    private final IMenuService menuService;
    private final ProductSizeRepository productSizeRepository;

    public MenuController(IMenuService menuService, ProductSizeRepository productSizeRepository) {
        this.menuService = menuService;
        this.productSizeRepository = productSizeRepository;
    }

    // This Method Is Responsible for Adding New Resturant Menu to Microservice
    @PostMapping(path = "/add")
    public ResponseEntity<String> addMenu( @RequestBody MenuDto menuDto ) throws Exception , MethodArgumentNotValidException {
        return menuService.addMenu(menuDto);
    }

    // This Method Is Responsible for Updating Resturant Menu in Microservice
    @PutMapping(path = "/sync")
    public ResponseEntity<String> syncMenu(@RequestParam Integer menuId, @RequestBody MenuDto menuDto) throws Exception , MethodArgumentNotValidException {
        return menuService.syncMenu(menuId,menuDto);
    }

    // This Method Gets Menus from Microservice
    @GetMapping(path = "/get" , produces = {"application/json"})
    public ResponseEntity<Menu> getMenuById(@RequestParam(value = "menuId"  ) Integer menuId) throws Exception , RecordNotFoundException {
        return  menuService.getMenuById(menuId);
    }

    // This Method Update Product Stock in Microservice
    @PutMapping(path = "/updateStock")
    public ResponseEntity<String> updateStock(@RequestBody ProductUpdateDto productUpdateDto) throws Exception , MethodArgumentNotValidException {
        return menuService.updateStock(productUpdateDto);
    }

}
