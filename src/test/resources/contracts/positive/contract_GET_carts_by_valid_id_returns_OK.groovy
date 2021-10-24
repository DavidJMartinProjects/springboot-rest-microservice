package contracts.positive

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 200 status code given valid cart id: 1"
    request {
        method GET()
        url("/cart") {
            queryParameters {
                parameter("id", "1")
            }
        }
    }
    response {        
        status 200
    }
}