package com.example.hibiscopricing.controller;

import com.example.hibiscopricing.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PricingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void givenProductRequest_whenTimeIs10Day14_ThenReturnPrice35() throws Exception {
        mockMvc.perform(post("/v1/pricing/price")
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .queryParam("date", "2020-06-14T10:00:00.000Z")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void givenProductRequest_whenTimeIs16Day14_ThenReturnPrice25() throws Exception {
        mockMvc.perform(post("/v1/pricing/price")
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .queryParam("date", "2020-06-14T16:00:00.000Z")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void givenProductRequest_whenTimeIs21Day14_ThenReturnPrice35() throws Exception {
        mockMvc.perform(post("/v1/pricing/price")
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .queryParam("date", "2020-06-14T21:00:00.000Z")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void givenProductRequest_whenTimeIs10Day15_ThenReturnPrice30() throws Exception {
        mockMvc.perform(post("/v1/pricing/price")
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .queryParam("date", "2020-06-15T10:00:00.000Z")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void givenProductRequest_whenTimeIs21Day16_ThenReturnPrice38() throws Exception {
        mockMvc.perform(post("/v1/pricing/price")
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .queryParam("date", "2020-06-16T21:00:00.000Z")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(38.95));
    }
}
