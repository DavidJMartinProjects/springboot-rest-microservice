import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return even when number input is even"
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