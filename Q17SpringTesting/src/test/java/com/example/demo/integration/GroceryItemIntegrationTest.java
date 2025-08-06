package com.example.demo.integration;

import com.example.demo.entity.GroceryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GroceryItemIntegrationTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void fullCrudFlow() {
        GroceryItem toCreate = new GroceryItem(null,"Dosa",10,2.5);
        ResponseEntity<GroceryItem> postResp = rest.postForEntity("/api/grocery", toCreate, GroceryItem.class);
        Assertions.assertEquals(HttpStatus.CREATED, postResp.getStatusCode());
        GroceryItem created = postResp.getBody();
        Assertions.assertNotNull(created);
        Long id = created.getId();

        ResponseEntity<GroceryItem> getResp = rest.getForEntity("/api/grocery/" + id, GroceryItem.class);
        Assertions.assertEquals(HttpStatus.OK, getResp.getStatusCode());
        Assertions.assertEquals("Dosa", getResp.getBody().getName());

        GroceryItem updated = new GroceryItem(null,"Dosa Masala",5,3.0);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GroceryItem> putEntity = new HttpEntity<>(updated, headers);
        ResponseEntity<GroceryItem> putResp = rest.exchange("/api/grocery/" + id, HttpMethod.PUT, putEntity, GroceryItem.class);
        Assertions.assertEquals(HttpStatus.OK, putResp.getStatusCode());
        Assertions.assertEquals("Dosa Masala", putResp.getBody().getName());

        ResponseEntity<Void> delResp = rest.exchange("/api/grocery/" + id, HttpMethod.DELETE, null, Void.class);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, delResp.getStatusCode());
    }
}
