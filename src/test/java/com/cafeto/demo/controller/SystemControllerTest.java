package com.cafeto.demo.controller;

import com.cafeto.demo.DemoApplication;
import com.cafeto.demo.dto.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test implementation for SystemController class
 * @author Edwin Hidalgo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SystemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String URL_COMPARE_PROPERTY;

    static {
        URL_COMPARE_PROPERTY = "http://localhost:8080/cafeto/compareProperty/";
    }

    @Test
    public void success_property_exist(){
        Request request = new Request();
        request.setProperty("os.version");
        request.setValue("10.0");

        HttpEntity<Object> entity = createRequest(request, MediaType.APPLICATION_JSON);
        ResponseEntity<Void> response = restTemplate.exchange(URL_COMPARE_PROPERTY, HttpMethod.POST, entity, Void.class);
        assertThat(response.getStatusCode()).isSameAs(HttpStatus.OK);
    }

    @Test
    public void success_property_does_not_true(){
        Request request = new Request();
        request.setProperty("os.version");
        request.setValue("12.0");

        HttpEntity<Object> entity = createRequest(request, MediaType.APPLICATION_JSON);
        ResponseEntity<Void> response = restTemplate.exchange(URL_COMPARE_PROPERTY, HttpMethod.POST, entity, Void.class);
        assertThat(response.getStatusCode()).isSameAs(HttpStatus.NOT_FOUND);
    }

    @Test
    public void failed_property_does_not_exist(){
        Request request = new Request();
        request.setProperty("os.vertion");
        request.setValue("10.0");

        HttpEntity<Object> entity = createRequest(request, MediaType.APPLICATION_JSON);
        ResponseEntity<Void> response = restTemplate.exchange(URL_COMPARE_PROPERTY, HttpMethod.POST, entity, Void.class);
        assertThat(response.getStatusCode()).isSameAs(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void failed_withEmpty_request(){
        Request request = new Request();

        HttpEntity<Object> entity = createRequest(request, MediaType.APPLICATION_JSON);
        ResponseEntity<Void> response = restTemplate.exchange(URL_COMPARE_PROPERTY, HttpMethod.POST, entity, Void.class);
        assertThat(response.getStatusCode()).isSameAs(HttpStatus.BAD_REQUEST);
    }

    private HttpEntity<Object> createRequest(Object object, MediaType accept) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (Objects.nonNull(accept)) {
            headers.setAccept(List.of(accept));
        }
        return new HttpEntity<>(object,headers);
    }
}
