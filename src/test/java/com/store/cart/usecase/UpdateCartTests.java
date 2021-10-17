package com.store.cart.usecase;

import java.util.Objects;

import com.store.cart.IntegrationTestBase;
import com.store.cart.model.dto.CartDto;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class UpdateCartTests extends IntegrationTestBase {

    @Test
    void GIVEN_updatedCart_WHEN_putRequestToCartById_THEN_ok() {
        // given
        long existingCartId = 1L;

        CartDto cart =
            webTestClient
                .get()
                .uri(CART_API_BASE_PATH + "/" + existingCartId)
                .exchange()
                .returnResult(CartDto.class)
                .getResponseBody()
                .blockFirst();

        Objects.requireNonNull(cart)
            .setTotalPrice(111.11);

        // when
        webTestClient
            .put()
            .uri(CART_API_BASE_PATH + "/" + cart.getId())
            .body(Mono.just(cart), CartDto.class)
            .exchange()

            // then
            .expectStatus()
            .isOk()
            .expectBody(CartDto.class)
            .isEqualTo(cart);
    }

}
