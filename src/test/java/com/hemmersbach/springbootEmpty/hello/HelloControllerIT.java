package com.hemmersbach.springbootEmpty.hello;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort private int port;

    private URL base;
    private URL baseA;
    private URL baseB;

    @Autowired private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base  = new URL("http://localhost:" + port + "/");
        this.baseA = new URL("http://localhost:" + port + "/testA");
        this.baseB = new URL("http://localhost:" + port + "/testB");
    }

    @Test
    public void index() throws Exception {
        String strRestResponse = "Angel test. I am here first @RequestMapping";
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(), equalTo(strRestResponse));
    }

    @Test
    public void indexA() throws Exception {
        String strRestResponse = "I am in testA";
        ResponseEntity<String> response = template.getForEntity(baseA.toString(), String.class);
        assertThat(response.getBody(), equalTo(strRestResponse));
    }

    @Test
    public void indexB() throws Exception {
        String strRestResponse = "I am in testB";
        ResponseEntity<String> response = template.getForEntity(baseB.toString(), String.class);
        assertThat(response.getBody(), equalTo(strRestResponse));
    }
}