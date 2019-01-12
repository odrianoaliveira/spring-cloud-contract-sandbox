package tech.adriano.sandbox.contractvalidation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.adriano.sandbox.contractvalidation.model.IP;

@RestController
@RequiredArgsConstructor
public class IpController {
    private final IpService service;

    @GetMapping(path = "/get")
    public ResponseEntity<IP> get() {
        return ResponseEntity.ok(service.getIp());
    }
}
