package com.store.cart.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author david
 */
@Table(name = "cart")
@Entity
@Getter
@Setter
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<ItemEntity> itemEntities;

    @Column(name = "total_price")
    private double totalPrice;

}