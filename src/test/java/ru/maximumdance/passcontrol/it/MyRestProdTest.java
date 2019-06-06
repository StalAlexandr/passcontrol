package ru.maximumdance.passcontrol.it;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("prod")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyRestProdTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFindById() throws Exception {
        ResponseEntity<String> entity =
                testRestTemplate.exchange("/", HttpMethod.GET, null, String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        String actual = entity.getBody();
        Assert.assertEquals(actual, "MyServiceImpl");
    }
}


