package com.example.backend.dtos;

import com.example.backend.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO extends Product {
    private String category_name;
    private String brand_name;
    private List<String> list_size;
}
