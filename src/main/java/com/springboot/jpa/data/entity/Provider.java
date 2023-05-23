package com.springboot.jpa.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "provider")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Provider extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
