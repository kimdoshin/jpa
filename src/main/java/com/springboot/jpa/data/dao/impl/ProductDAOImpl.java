package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Optional;


@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProduct(Long number) {
        return productRepository.getById(number);
    }

    @Override
    @Transactional
    public Product updateProductName(Long number, String name)  {
        Optional<Product> selectProduct = productRepository.findById(number);

        Product updateProduct;
        if (selectProduct.isPresent()) {
            Product product = selectProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());
            try {
                updateProduct = productRepository.save(product);
            }catch (Exception ex) {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);

        if (selectProduct.isPresent()) {
            Product product = selectProduct.get();
            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
