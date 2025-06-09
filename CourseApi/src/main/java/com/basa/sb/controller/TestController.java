package com.basa.sb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class TestController {
    @GetMapping("/test")
    public String getResponse() throws JsonProcessingException {
        String url = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonResponse = response.getBody();
        System.out.println("Raw JSON: " + jsonResponse);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("mapper"+mapper);
        JsonNode rootNode = mapper.readTree(jsonResponse);
        System.out.println("rootNode"+rootNode);
        System.out.println("id is---"+rootNode.path("id").asInt());
        System.out.println(rootNode.path("title").asText());
        System.out.println(rootNode.path("price").asDouble());
        System.out.println(rootNode.path("description").asText());
        System.out.println(rootNode.path("category").asText());
        System.out.println(rootNode.path("image").asText());
        System.out.println(rootNode.path("rating").asText());
        return jsonResponse;
    }
}
