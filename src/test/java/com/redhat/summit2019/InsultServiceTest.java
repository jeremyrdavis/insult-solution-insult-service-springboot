package com.redhat.summit2019;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.redhat.summit2019.model.Adjective;
import com.redhat.summit2019.model.Noun;
import com.redhat.summit2019.service.AdjectiveService;
import com.redhat.summit2019.service.NounService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InsultServiceTest {

    private static final String ENDPOINT_PATH = "api/insult";

    @Value("${local.server.port}")
    private int port;

    @MockBean
    AdjectiveService adjectiveService;

    @MockBean
    NounService nounService;

    @Before
    public void setUp(){

        Mockito.when(nounService.getNoun()).thenReturn(new Noun("pantaloon"));
        Mockito.when(adjectiveService.getAdjective()).thenAnswer(new Answer<Adjective>() {
            private int count = 0;
            public Adjective answer(InvocationOnMock invocation) {
                if (count++ == 1)
                    return new Adjective(("cockle-brained"));
                return new Adjective("puking");
            }
        });
        RestAssured.baseURI = String.format("http://localhost:%d/api/insult", port);
    }

    @Test
    public void testInsultService() {
        Response response = given()
           .baseUri(baseURI())
           .get(ENDPOINT_PATH)
           .then()
           .statusCode(200)
           .extract().response();
        assertNotNull(response);

        assertEquals("{\"insult\":\"Verily, ye be a puking, cockle-brained pantaloon!\"}", response.body().asString());
    }

    protected String baseURI() {
        return String.format("http://localhost:%d", port);
    }

}