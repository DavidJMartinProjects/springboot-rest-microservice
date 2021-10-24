package contracts.negative

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 404 status code given invalid cart id: abc"
    request {
        method GET()
        url("/cart") {
            queryParameters {
                parameter("id", "abc")
            }
        }
    }
    response {
        status 404
    }
}