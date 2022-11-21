package com.example.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "order_item")
    private String order_item;

    @Column(name = "account_id")
    private int account_id;

    @Column(name = "status")
    private int status;

    @Column(name = "address_from")
    private String address_from;

    @Column(name = "address_to")
    private String address_to;

    @Column(name = "type_payment")
    private int type_payment;

    @Column(name = "time_delivery")
    @CreationTimestamp
    private Date time_delivery;

    @Column(name = "cart_id")
    private int cart_id;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Date update_at;

    @Column(name = "deleted_at")
    @UpdateTimestamp
    private Date deleted_at;
}
