package com.springboot.jpa.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name="product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @OneToOne(mappedBy = "product")
    @ToString.Exclude
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    @ToString.Exclude
    private Provider provider;

}
