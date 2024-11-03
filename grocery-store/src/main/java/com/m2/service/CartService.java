package com.m2.service;

import com.m2.dto.CartDTO;
import com.m2.dto.SelectedProductDTO;
import com.m2.entity.Cart;

public interface CartService {
    public String addItemToCart(CartDTO cartDTO);
    public String removeItemToCart(Integer productId,Integer cartId);

    Cart getAllCartItem(Integer cartId);
}
