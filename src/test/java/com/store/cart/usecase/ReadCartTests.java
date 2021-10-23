package com.store.cart.usecase;

import java.util.Collection;

import org.springframework.http.HttpStatus;

import com.store.cart.IntegrationTestBase;
import org.openapitools.model.CartDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class ReadCartTests extends IntegrationTestBase {

    // <-- Positive GET Requests Tests -->
    @Test
    void WHEN_getRequestToCarts_THEN_ok() {
        // when
        webTestClient
            .get()
            .uri(CART_API_BASE_PATH)
            .exchange()

            // then
            .expectStatus()
            .isOk()
            .expectBody(Collection.class);
    }

    @Test
    void GIVEN_existingCartId_WHEN_getRequestToCartById_THEN_ok() {
        // given
        long existingCartId = 1L;

        // when
        webTestClient
            .get()
            .uri(CART_API_BASE_PATH + "/" + existingCartId)
            .exchange()

            // then
            .expectStatus()
            .isOk()
            .expectBody(CartDto.class);
    }

    // <-- Negative GET Requests Tests -->
    @Test
    void GIVEN_nonExistingCartId_WHEN_getRequestToCartById_THEN_notFound() {
        // given
        long nonExistingCartId = 100;

        // when
        webTestClient
            .get()
            .uri(CART_API_BASE_PATH + "/" + nonExistingCartId)
            .exchange()

            // then
            .expectStatus()
            .isEqualTo(HttpStatus.NOT_FOUND)
            .expectBody()
            .jsonPath("$.errorCode").value(Matchers.is(404))
            .jsonPath("$.developerMessage").value(Matchers.equalTo("Record not found."))
            .jsonPath("$.message").value(Matchers.containsString("Cart with id:{[" + nonExistingCartId + "}] does not exist."));
    }

}

