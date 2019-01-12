package tech.adriano.sandbox.contractvalidation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.adriano.sandbox.contractvalidation.conector.HttpBinClient;
import tech.adriano.sandbox.contractvalidation.model.IP;

@Service
@RequiredArgsConstructor
public class IpService {
    private final HttpBinClient client;

    public IP getIp(){
        return client.get();
    }
}
