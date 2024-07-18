package com.Order.Order_App.Models;

import com.Order.Order_App.Models.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(name = "product_name")
    private String productName;

    @NotNull(message = "Product quantity is required")
    @Min(value = 1, message = "Product quantity must be at least 1")
    @Column(name = "product_quantity")
    private Integer productQuantity;

    @NotNull(message = "Product price is required")
    @Min(value = 0, message = "Product price must be at least 0")
    @Column(name = "product_price")
    private Double productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
