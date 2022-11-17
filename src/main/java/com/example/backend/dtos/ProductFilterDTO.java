package com.example.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFilterDTO {
    private int category_id;
    private List<String> list_color;
    private List<String> list_size;
    private String price_sort;
}
