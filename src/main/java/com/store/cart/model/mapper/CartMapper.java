package com.store.cart.model.mapper;

import com.store.cart.model.dto.CartDto;
import com.store.cart.model.entity.CartEntity;
import org.mapstruct.Mapper;

/**
 * @author david
 */
@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(CartEntity cartEntity);
    CartEntity toEntity(CartDto cartDto);
}
