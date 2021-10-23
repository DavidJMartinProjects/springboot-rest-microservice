package com.store.cart.service.impl;

import org.openapitools.model.CartDto;
import com.store.cart.model.entity.CartEntity;

import com.store.cart.model.mapper.CartMapper;
import com.store.cart.repository.CartRepository;
import com.store.cart.service.CartService;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

/**
 * @author david
 */
@Service
public class CartServiceImpl implements CartService {

    private static final CartMapper CART_MAPPER = Mappers.getMapper(CartMapper.class);

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartDto> findCarts() {
        return cartRepository.findAll()
            .stream()
            .map(CART_MAPPER::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public CartDto findCartById(long id) {
        return cartRepository.findById(id)
            .map(CART_MAPPER::toDto)
            .orElseThrow(() -> new EntityNotFoundException("Cart with id:{[" + id + "}] does not exist."));
    }

    @Override
    public CartDto updateCartById(long id, CartDto cart) {
        cart.setId(id);
        CartEntity updatedCart = cartRepository.save(CART_MAPPER.toEntity(cart));
        return CART_MAPPER.toDto(updatedCart);
    }

    @Override
    public CartDto createCart(CartDto cart) {
        CartEntity updatedCart = cartRepository.save(CART_MAPPER.toEntity(cart));
        return CART_MAPPER.toDto(updatedCart);
    }

    @Override
    public void deleteCartById(long id) {
        if(existsById(id)) {
            cartRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cart with id:{[" + id + "}] does not exist.");
        }
    }

    @Override
    public boolean existsById(long id) {
        return cartRepository.existsById(id);
    }

}
