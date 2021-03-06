package com.store.cart.integration.usecase;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import com.store.cart.integration.IntegrationTestBase;
import org.springframework.http.HttpStatus;

class DeleteCartTests extends IntegrationTestBase {

    // <-- Positive DELETE Request Integration Tests -->
    @Test
    void GIVEN_existingCartId_WHEN_deleteRequestToCartById_THEN_noContent() {
        // given
        long existingCartId = 1L;

        // when
        webTestClient
            .delete()
            .uri(CART_API_BASE_PATH + "/" + existingCartId)
            .exchange()

            // then
            .expectStatus()
            .isNoContent()
            .expectBody()
            .isEmpty();
    }

    // <-- Negative DELETE Request Integration Tests -->
    @Test
    void GIVEN_nonExistingCartId_WHEN_deleteRequestToCartById_THEN_notFound() {
        // given
        long nonExistingCartId = 100;

        // when
        webTestClient
            .delete()
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
