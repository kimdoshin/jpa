package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name, Sort sort);
    List<Product> findByNameOrderByNameAsc(String name);

    Page<Product> findByName(String name, Pageable pageable);


    @Query("SELECT p.name, p.price, p.stock FROM Product AS p WHERE p.name = :name")
    List<Object[]> findByNameParam(@Param("name")String name);
}
