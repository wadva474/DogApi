package com.wadud.dogapi;

import com.wadud.dogapi.entity.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DogapiApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    

    @Test
    void contextLoads() {
    }

    @Test
    public void getAllDogs() {
        ResponseEntity<List> responseEntity =
                this.testRestTemplate.withBasicAuth("Admin","password")
                        .getForEntity("http://localhost:" + port + "/dogs/", List.class);

        assertThat(responseEntity.getStatusCode(),equalTo(HttpStatus.OK));
    }

}
