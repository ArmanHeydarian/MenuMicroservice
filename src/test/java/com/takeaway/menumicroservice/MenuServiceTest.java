package com.takeaway.menumicroservice;

import com.takeaway.menumicroservice.domain.dto.*;
import com.takeaway.menumicroservice.domain.model.*;
import com.takeaway.menumicroservice.repository.MenuRepository;
import com.takeaway.menumicroservice.repository.ProductSizeRepository;
import com.takeaway.menumicroservice.service.*;
import com.takeaway.menumicroservice.service.util.MadelDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest()
class MenuServiceTest {

    //@Autowired
    IMenuService menuService;

    @MockBean
    MenuRepository menuRepository;

    @MockBean
    ProductSizeRepository productSizeRepository;

    MenuDto menuDto;
    Menu menu;
    ProductUpdateDto productUpdateDto;
    ProductSize productSize;

    @Test
    void addMenu() throws Exception {
        // Arrange
        Menu newMenu = MadelDtoMapper.convertToEntity(menuDto);
        Mockito.when(menuRepository.save(Mockito.any(Menu.class))).thenReturn(newMenu);
        // Action
        menuService = new MenuService(menuRepository,productSizeRepository);
        ResponseEntity<String> responseEntity =  menuService.addMenu(menuDto) ;
        // Assert
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }


    @Test
    void getMenuById() throws Exception {
        // Arrange
        Menu newMenu = MadelDtoMapper.convertToEntity(menuDto);
        Mockito.when(menuRepository.findByIdAndStatus(1, true)).thenReturn(java.util.Optional.ofNullable(menu));
        // Action
        menuService = new MenuService(menuRepository,productSizeRepository);
        ResponseEntity<Menu> responseEntity =  menuService.getMenuById(1) ;
        // Assert
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

    @BeforeEach  
    public void setUp() {
        productUpdateDto = new ProductUpdateDto(){{
            setAvailability(true);
            setMenuId(1);
            setSize(Size.LARGE);
            setProductId(1);
        }};

        productSize = new ProductSize() {{
            setAvailability(true);
            setSize(Size.SMALL);
            setPrice(120);
        }};
        menu = new Menu(){{
            setId(1);
            setTitle("Test Menu1");
            setResturants(new ArrayList<Resturant>(){{
                add(new Resturant(){{setResturantId(1);}});
            }});
            setCategories(new ArrayList<Category>(){{
                add(new Category(){{
                    setTitle("test Category 1");
                    setProducts(new ArrayList<Product>()
                    {{
                        add(new Product(){{
                            setTitle("test Product 1");
                            setDescription("Description1 ...");
                            setImageUrl("hgjh.jpg");
                            setProductSizes(new ArrayList<ProductSize>()
                            {{
                                add ( new ProductSize(){{setSize(Size.LARGE); setAvailability(true); setPrice(10);}});
                                add ( new ProductSize(){{setSize(Size.SMALL); setAvailability(false);setPrice(10);}});
                            }});

                        }});
                    }});
                }});
            }});
        }};

        menuDto = new MenuDto(){{
            setTitle("Test Menu2");
            setResturants(new ArrayList<ResturantDto>(){{
                add(new ResturantDto(){{setResturantId(1);}});
            }});
            setCategories(new ArrayList<CategoryDto>(){{
                add(new CategoryDto(){{
                    setTitle("test Category 2");
                    setProducts(new ArrayList<ProductDto>()
                    {{
                        add(new ProductDto(){{
                            setTitle("test Product 2");
                            setDescription("Description1 ...");
                            setImageUrl("hgjh.jpg");
                            setProductSizes(new ArrayList<ProductSizeDto>()
                                            {{
                                                add ( new ProductSizeDto(){{setSize(Size.LARGE); setAvailability(true); setPrice(10);}});
                                                add ( new ProductSizeDto(){{setSize(Size.SMALL); setAvailability(false);setPrice(10);}});
                                            }});

                        }});
                    }});
                }});
            }});
        }};

    }


}