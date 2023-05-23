package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ProductRepositoryAdTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(1000);
        product2.setStock(100);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(1000);
        product3.setStock(100);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product saveProduct1 = productRepository.save(product1);
        Product saveProduct2 = productRepository.save(product2);
        Product saveProduct3 = productRepository.save(product3);


        List<Product> list = productRepository.findByName("펜", getSort());

        for (Product product : list) {
            System.out.println(product);
        }

        List<Product> list2 = productRepository.findByNameOrderByNameAsc("펜");

        for (Product product : list2) {
            System.out.println(product);
        }

        Page<Product> list3 = productRepository.findByName("펜", PageRequest.of(1,2));

        List<Object[]> list4 = productRepository.findByNameParam("펜");
    }


    private Sort getSort() {
        return Sort.by(Sort.Order.asc("price"), Sort.Order.desc("stock"));
    }
}
