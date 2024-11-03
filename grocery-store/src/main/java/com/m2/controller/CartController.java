package com.m2.controller;

import com.m2.dto.CartDTO;
import com.m2.dto.ProductDTO;
import com.m2.dto.SelectedProductDTO;
import com.m2.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("addItems")
    public ResponseEntity<?> addItemToCart(@RequestBody CartDTO dto){
        return ResponseEntity.ok(cartService.addItemToCart(dto));
    }

    @GetMapping("cartItems")
    public ResponseEntity<?> getAllCartItem(@RequestParam Integer id){
        return ResponseEntity.ok(cartService.getAllCartItem(id));
    }

    @DeleteMapping("removeItem")
    public ResponseEntity<?> removeItemFromCart(@RequestParam Integer productId,@RequestParam Integer cartId){
        return ResponseEntity.ok(cartService.removeItemToCart(productId,cartId));
    }
}
