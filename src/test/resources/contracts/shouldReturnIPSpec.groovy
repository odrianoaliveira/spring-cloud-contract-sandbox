package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/get'
    }
    response {
        status 200
        headers {
            contentType applicationJsonUtf8()
        }
        body(origin: "10.0.0.1", url: "http://mock.org")
    }
}