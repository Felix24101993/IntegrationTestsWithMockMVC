package com.integrationtests.demo.controllerIntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
public class ProductControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testFindAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..technicalDetails..id").isNotEmpty());
    }

    @Test
    public void testFindAllTechnicalDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/technical-details")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..title", hasSize(4)));
    }

    @Test
    public void testFindAllTechnicalDetailsForProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/technical-details/products/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..id", hasItem("3")));
    }

    @Test
    public void testProductByWrongIdException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/6")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }


}