package com.m2.service;

import com.m2.dto.CartDTO;
import com.m2.entity.Cart;
import com.m2.dto.SelectedProductDTO;
import com.m2.entity.SelectedProduct;
import com.m2.repository.CartRepository;
import com.m2.repository.SelectedProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final SelectedProductRepository selectedProductRepository;
    /**
     * @param cartDTO
     * @return
     */

    @Override
    public String addItemToCart(CartDTO cartDTO) {
        Cart cart=cartRepository.findById(cartDTO.getCartId()).orElse(cartRepository.save(Cart.builder()
                        .userId(cartDTO.getUserId())
                        .build()));
        List<SelectedProduct> selectedProducts=cartDTO.getProducts().stream().map(dto->convertDTO(dto,cart)).toList();
        selectedProducts=selectedProductRepository.saveAll(selectedProducts);
        return "Item added to cart";
    }
    private SelectedProduct convertDTO(SelectedProductDTO dto,Cart cart) {
        return SelectedProduct.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .cartId(cart.getCartId())
                .build();
    }

    /**
     * @param productId and cartId
     * @return
     */
    @Transactional
    @Override
    public String removeItemToCart(Integer productId, Integer cartId) {
        selectedProductRepository.deleteByProductIdAndCartId(productId,cartId);
        return "item remove from cart";
    }
    /**
     * @param cartId
     * @return
     */
    @Override
    public Cart getAllCartItem(Integer cartId) {
        Cart cart=cartRepository.findById(cartId).get();
        return cart;
    }
}
