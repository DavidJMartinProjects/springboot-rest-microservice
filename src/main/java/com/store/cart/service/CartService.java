package com.store.cart.service;

import org.openapitools.model.CartDto;

import java.util.List;

/**
 * @author david
 */
public interface CartService {
    List<CartDto> findCarts();
    CartDto findCartById(long id);
    CartDto updateCartById(long id, CartDto cart);
    CartDto createCart(CartDto cart);
    void deleteCartById(long id);
    boolean existsById(long id);
}
