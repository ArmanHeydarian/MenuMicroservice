package com.takeaway.menumicroservice.repository;

import com.takeaway.menumicroservice.domain.dto.Size;
import com.takeaway.menumicroservice.domain.model.Menu;
import com.takeaway.menumicroservice.domain.model.Product;
import com.takeaway.menumicroservice.domain.model.ProductSize;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductSizeRepository extends CrudRepository<ProductSize, Integer> {

    @Query("SELECT ps from ProductSize ps where ps.product.category.menu.status = true and ps.product.id = :productId and ps.size = :size")
    Optional<ProductSize> findProductSizeByProductIdAndSize(@Param("productId") Integer productId, @Param("size") Size size);
}