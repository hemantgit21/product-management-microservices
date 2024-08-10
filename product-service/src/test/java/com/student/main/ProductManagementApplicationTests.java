package com.student.main;

import lombok.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.main.dto.ProductRequest;
import com.student.main.repository.ProductRepository;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductManagementApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    static DockerImageName myImage = DockerImageName.parse("mongo").asCompatibleSubstituteFor("mongo");
    @Container
    static MongoDBContainer mongodbContainer = new MongoDBContainer(myImage);

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongodbContainer::getReplicaSetUrl);
    }

    @Test
    void shouldCreateProduct() throws Exception {
        // Create a product request object
        ProductRequest productRequest = getProductRequest();

        // Convert the product request object to a JSON string
        String productRequestString = objectMapper.writeValueAsString(productRequest);

        // Perform a POST request to the /api/product endpoint with the request body
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestString))
                .andExpect(status().isCreated()); // Expect HTTP 201 Created status

        // Verify that the product was saved in the repository
        assertTrue(productRepository.findAll().size() == 1);
    }

    private ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name("Test Product")
                .description("Test Description")
                .price(BigDecimal.valueOf(999.99))
                .build();
    }
}
