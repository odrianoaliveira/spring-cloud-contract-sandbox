package tech.adriano.sandbox.contractvalidation.conector;

import feign.RequestLine;
import tech.adriano.sandbox.contractvalidation.model.IP;

public interface HttpBinClient {

    @RequestLine("GET /get")
    IP get();

}
