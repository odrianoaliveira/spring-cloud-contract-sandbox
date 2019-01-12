package tech.adriano.sandbox.contractvalidation;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWireMock(port = 9090)
public abstract class BaseContractTest {

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        stubFor(get(urlEqualTo("/get"))
                .willReturn(
                        aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("{\"origin\":\"10.0.0.1\",\"url\": \"https://httpbin.org/get\"}")));
        RestAssuredMockMvc.webAppContextSetup(context);
    }
}
