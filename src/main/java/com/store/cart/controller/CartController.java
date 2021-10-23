package com.store.cart.controller;

import org.openapitools.api.CartApi;
import org.openapitools.model.CartDto;

import com.store.cart.service.CartService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author david
 */
@RestController
@Slf4j
public class CartController implements CartApi {

    public static final String CART_BASE_PATH = "/cart";

    @Autowired
    private CartService cartService;

    @Override
    public ResponseEntity<List<CartDto>> getCarts() {
        log.info("GET: {}", CART_BASE_PATH);
        return ResponseEntity.ok(cartService.findCarts());
    }

    @Override
    public ResponseEntity<CartDto> getCartById(Long id) {
        log.info("GET: {}", CART_BASE_PATH + "/" + id);
        return ResponseEntity.ok(cartService.findCartById(id));
    }

    @Override
    public ResponseEntity<CartDto> updateCartById(Long id, CartDto cart) {
        log.info("PUT: {}", CART_BASE_PATH + "/" + id);
        if(cartService.existsById(id)) {
            return ResponseEntity.ok(cartService.updateCartById(id, cart));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.updateCartById(id, cart));
    }

    @Override
    public ResponseEntity<CartDto> createCart(CartDto cart) {
        log.info("POST: {}", CART_BASE_PATH);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.createCart(cart));
    }

    @Override
    public ResponseEntity<Void> deleteCartById(Long id) {
        log.info("DELETE: {}", CART_BASE_PATH + "/" + id);
        cartService.deleteCartById(id);
        return ResponseEntity.noContent().build();
    }

}
