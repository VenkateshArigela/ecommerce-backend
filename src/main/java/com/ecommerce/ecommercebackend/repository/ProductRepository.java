package com.ecommerce.ecommercebackend.repository;

import com.ecommerce.ecommercebackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}