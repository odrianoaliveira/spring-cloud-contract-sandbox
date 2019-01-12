package tech.adriano.sandbox.contractvalidation;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import tech.adriano.sandbox.contractvalidation.model.IP;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {

    @Before
    public void setup() {
        IpService ipService = mock(IpService.class);
        when(ipService.getIp()).thenReturn(IP.builder().origin("10.0.0.1").url("http://mock.org").build());
        RestAssuredMockMvc.standaloneSetup(new IpController(ipService));
    }
}
