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
@Table(name = "discount")
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discount_id;

    @Column(name = "discount_code")
    private String discount_code;

    @Column(name = "discount_name")
    private String discount_name;

    @Column(name = "status")
    private int status;

    @Column(name = "value")
    private String value;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "end_date")
    @CreationTimestamp
    private Date end_date;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Date update_at;

    @Column(name = "deleted_at")
    @UpdateTimestamp
    private Date deleted_at;
}
