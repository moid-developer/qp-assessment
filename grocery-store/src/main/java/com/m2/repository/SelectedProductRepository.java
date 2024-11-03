package com.m2.repository;

import com.m2.entity.SelectedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SelectedProductRepository extends JpaRepository<SelectedProduct,Integer> {

    @Modifying
    @Query(value = "DELETE FROM SELECTED_PRODUCT WHERE PRODUCT_ID=:productId AND CART_ID=:cartId", nativeQuery = true)
    void deleteByProductIdAndCartId(Integer productId,Integer cartId);
}
