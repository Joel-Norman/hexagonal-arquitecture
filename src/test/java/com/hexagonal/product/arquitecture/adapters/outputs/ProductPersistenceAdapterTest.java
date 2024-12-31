package com.hexagonal.product.arquitecture.adapters.outputs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexagonal.product.domain.Product;
@SpringBootTest
public class ProductPersistenceAdapterTest {

	@Autowired
    private ProductPersistenceAdapter adapter;

    @Test
    void testCreate() {
        Product expectedProd = new Product("1234", "skuproducto2", "producto2", "descripcion del producto 2");
        Product prod = adapter.save(expectedProd);
        

        assertEquals(expectedProd.getDescription(),prod.getDescription());
        assertEquals(expectedProd.getId(),prod.getId());
        assertEquals(expectedProd.getName(),prod.getName());
        assertEquals(expectedProd.getSku(),prod.getSku());
    }
    
    @Test
    void testListNotEmpty() {
        List<Product> list = adapter.list();
        assertFalse(list.isEmpty());
        
    }
    
    @Test
    void testFind() {
        Product expectedProd = new Product("1234", "skuproducto2", "producto2", "descripcion del producto 2");
        Product prod = adapter.getBySku("skuproducto2");
        
        assertEquals(expectedProd.getDescription(),prod.getDescription());
        assertEquals(expectedProd.getId(),prod.getId());
        assertEquals(expectedProd.getName(),prod.getName());
        assertEquals(expectedProd.getSku(),prod.getSku());
    }
    @DisplayName("Al buscar uno que no existe retorna null")
    @Test
    void testFindNotExist() {
        Product prod = adapter.getBySku(null);
        
        assertEquals(null,prod);
    }

}
