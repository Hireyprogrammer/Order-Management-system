package com.Order.Order_App.Repository;

import com.Order.Order_App.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
