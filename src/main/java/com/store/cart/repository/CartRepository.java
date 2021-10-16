package com.store.cart.repository;

import com.store.cart.model.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author david
 */
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}