package com.example.backend.repositories;

import com.example.backend.entities.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor, Integer> {
}
