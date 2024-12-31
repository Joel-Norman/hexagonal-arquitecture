package com.hexagonal.product.arquitecture.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.product.aplication.ports.inputs.ProductPort;
import com.hexagonal.product.arquitecture.adapters.outputs.model.ProductModel;
import com.hexagonal.product.domain.Product;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
 
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductPort productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateProduct_Error404() throws Exception {
        Product product = new Product("3333", "skuproducto3", "producto2", "descripcion del producto 2");

        when(productService.saveProduct(product)).thenReturn(product);
        mockMvc.perform(post("/products") //mal el endpoint
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isNotFound());
    }
    @Test
    public void testCreateProduct_Success() throws Exception {
        Product product = new Product("3333", "skuproducto3", "producto2", "descripcion del producto 2");

        when(productService.saveProduct(product)).thenReturn(product);
        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated());
    }

}
