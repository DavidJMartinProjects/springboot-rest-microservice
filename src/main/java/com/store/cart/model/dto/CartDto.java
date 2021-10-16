package com.store.cart.model.dto;

import com.store.cart.model.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author david
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Long id;

    private long customerId;
    private double totalPrice;
    private List<ItemEntity> itemEntities;

}
