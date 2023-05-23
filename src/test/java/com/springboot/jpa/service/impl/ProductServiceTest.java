package com.springboot.jpa.service.impl;


import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.dao.impl.ProductDAOImpl;
import com.springboot.jpa.data.dto.ProductDto;
import com.springboot.jpa.data.dto.ProductResponseDto;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProductServiceTest {


    private ProductDAO productDAO = Mockito.mock(ProductDAOImpl.class);


    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(productDAO);
    }

    @Test
    void getProductTest() {

        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("펜");
        givenProduct.setPrice(1000);
        givenProduct.setStock(1234);

        Mockito.when(productDAO.selectProduct(123L)).thenReturn(givenProduct);

        ProductResponseDto productResponseDto = productService.getProduct(123L);

        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        verify(productDAO).selectProduct(123L);

    }

    @Test
    void saveProductTest() {

        Mockito.when(productDAO.insertProduct(any(Product.class))).then(returnsFirstArg());

        ProductResponseDto productResponseDto = productService.saveProduct(new ProductDto("펜", 1000, 1234));

        Assertions.assertEquals(productResponseDto.getName(), "펜");

        verify(productDAO).insertProduct(any());

    }
}
