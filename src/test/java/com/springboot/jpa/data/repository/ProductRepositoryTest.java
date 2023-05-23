package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
        Product product = new Product();
        product.setName("pen");
        product.setPrice(1000);
        product.setStock(123);

        Product savedProduct = productRepository.save(product);

        Assertions.assertEquals(product.getName(), savedProduct.getName());


    }
}
