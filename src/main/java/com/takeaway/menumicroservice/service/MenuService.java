package com.takeaway.menumicroservice.service;

import com.takeaway.menumicroservice.ExceptionHandler.RecordNotFoundException;
import com.takeaway.menumicroservice.domain.dto.MenuDto;
import com.takeaway.menumicroservice.domain.dto.ProductUpdateDto;
import com.takeaway.menumicroservice.domain.model.ProductSize;
import com.takeaway.menumicroservice.repository.ProductSizeRepository;
import com.takeaway.menumicroservice.service.util.MadelDtoMapper;
import com.takeaway.menumicroservice.domain.model.Menu;
import com.takeaway.menumicroservice.repository.MenuRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Optional;

@Service
@Transactional
public class MenuService implements IMenuService{
    private final MenuRepository menuRepository;
    private final ProductSizeRepository productSizeRepository;
    protected static final Logger logger = LogManager.getLogger(MenuService.class);

    public MenuService(MenuRepository menuRepository, ProductSizeRepository productSizeRepository) {
        this.menuRepository = menuRepository;
        this.productSizeRepository = productSizeRepository;
    }
    //----------------------------------------------------------------------------------------------
    public ResponseEntity<String> addMenu(MenuDto menuDto) throws Exception, MethodArgumentNotValidException {
        Menu newMenu = MadelDtoMapper.convertToEntity(menuDto);
        Menu savedMenu = menuRepository.save(newMenu);
        logger.info("Menu Added Successfully");
        return ResponseEntity.ok("Menu Saved Successfully, New Menu Id: "+savedMenu.getId());
    }
    //----------------------------------------------------------------------------------------------
    public ResponseEntity<String> syncMenu(Integer menuId , MenuDto menuDto) throws Exception, MethodArgumentNotValidException {

        Menu newMenu = MadelDtoMapper.convertToEntity(menuDto);
        Optional<Menu> optionalMenu = menuRepository.findByIdAndStatus(menuId, true);
        if (optionalMenu.isPresent()) {
            Menu oldMenu = optionalMenu.get();
            oldMenu.setStatus(false);  //  newMenu Status hase been 'True' by ModelMapper

            menuRepository.save(oldMenu);
            menuRepository.save(newMenu);
            logger.info("The Menu Updated Successfully");
            return ResponseEntity.ok("Menu Updated Successfully, New Menu Id: "+newMenu.getId());
        }
        else
        {
            throw new RecordNotFoundException("There is no Active Menu with this Id");
        }
    }

    //----------------------------------------------------------------------------------------------
    public ResponseEntity<Menu> getMenuById(Integer menuId) throws Exception, RecordNotFoundException
    {
        //Find the Active Menu
        Optional<Menu> optionalMenu = menuRepository.findByIdAndStatus(menuId, true);
        if (optionalMenu.isPresent()) {
            return ResponseEntity.ok(optionalMenu.get());
        }
        else
        {
            throw new RecordNotFoundException("Menu not found");
        }
    }

    //----------------------------------------------------------------------------------------------
    public ResponseEntity<String> updateStock(ProductUpdateDto productUpdateDto) throws Exception, RecordNotFoundException
    {
        Optional<Menu> optionalMenu = menuRepository.findByIdAndStatus(productUpdateDto.getMenuId(), true);
        if (optionalMenu.isPresent())
        {
            Optional<ProductSize> productSize = productSizeRepository.findProductSizeByProductIdAndSize(productUpdateDto.getProductId(), productUpdateDto.getSize());
            if (productSize.isPresent()) {
                productSize.get().setAvailability(productUpdateDto.getAvailability());
                productSizeRepository.save(productSize.get());
                logger.info("Product Stock updated");
                return ResponseEntity.ok("Product Stock updated");
            }
            else
            {
                throw new RecordNotFoundException("Product Stock not Found");
            }
        }
        else
        {
            throw new RecordNotFoundException("Menu Id not Found");
        }

    }
}
