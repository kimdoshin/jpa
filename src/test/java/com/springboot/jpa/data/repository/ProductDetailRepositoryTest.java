package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.entity.ProductDetail;
import com.springboot.jpa.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    public void saveAndReadTest() {

        Provider provider = new Provider();
        provider.setName("ㅇㅇ물산");

        providerRepository.save(provider);


        Product product = new Product();
        product.setName("스프링 부트 JPA");
        product.setPrice(5000);
        product.setStock(500);
        product.setProvider(provider);

        productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("스프링 부트와 함꼐 볼 수 있는 책");

        productDetailRepository.save(productDetail);



        //ProductDetail searchProductDetail = productDetailRepository.findById(product.getNumber()).get();
        Product searchProduct = productDetailRepository.findById(product.getNumber()).get().getProduct();

        //System.out.println(searchProductDetail);
        System.out.println(searchProduct);




    }
}
