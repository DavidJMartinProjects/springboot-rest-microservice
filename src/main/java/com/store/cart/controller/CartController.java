package com.store.cart.controller;

import com.store.cart.model.dto.CartDto;
import com.store.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author david
 */
@RestController
@RequestMapping(CartController.CART_BASE_PATH)
@Slf4j
public class CartController {

    public static final String CART_BASE_PATH = "/cart";

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Collection<CartDto>> getCarts() {
        log.info("GET: {}", CART_BASE_PATH);
        return ResponseEntity.ok(cartService.findCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable long id) {
        log.info("GET: {}", CART_BASE_PATH + "/" + id);
        return ResponseEntity.ok(cartService.findCartById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDto> updateCartById(@PathVariable long id, @RequestBody CartDto cart) {
        log.info("PUT: {}", CART_BASE_PATH + "/" + id);
        if(cartService.existsById(id)) {
            return ResponseEntity.ok(cartService.updateCartById(id, cart));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.updateCartById(id, cart));
    }

    @PostMapping
    public ResponseEntity<CartDto> createCart(@RequestBody CartDto cart) {
        log.info("POST: {}", CART_BASE_PATH);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.createCart(cart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartById(@PathVariable long id) {
        log.info("DELETE: {}", CART_BASE_PATH + "/" + id);
        cartService.deleteCartById(id);
        return ResponseEntity.noContent().build();
    }

}
