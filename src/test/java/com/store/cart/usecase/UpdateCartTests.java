package com.store.cart.usecase;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import org.openapitools.model.CartDto;
import com.store.cart.IntegrationTestBase;

class UpdateCartTests extends IntegrationTestBase {

    @Test
    void GIVEN_updatedCartWithExistingId_WHEN_putRequestToCartById_THEN_ok() {
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

        assert cart != null;
        cart.setTotalPrice(111.11);

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

    @Test
    void GIVEN_updatedCardWithNonExistingId_WHEN_putRequestToCartById_THEN_created() {
        // given
        long existingCartId = 1L;
        long nonExistingCartId = 2L;

        CartDto cart =
            webTestClient
                .get()
                .uri(CART_API_BASE_PATH + "/" + existingCartId)
                .exchange()
                .returnResult(CartDto.class)
                .getResponseBody()
                .blockFirst();

        assert cart != null;
        cart.setId(nonExistingCartId);
        cart.setTotalPrice(222.22);

        // when
        webTestClient
            .put()
            .uri(CART_API_BASE_PATH + "/" + nonExistingCartId)
            .body(Mono.just(cart), CartDto.class)
            .exchange()

            // then
            .expectStatus()
            .isCreated()
            .expectBody(CartDto.class)
            .isEqualTo(cart);
    }

}