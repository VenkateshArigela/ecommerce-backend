package com.ecommerce.ecommercebackend.controller;

import com.ecommerce.ecommercebackend.dto.ProductDTO;
import com.ecommerce.ecommercebackend.dto.ProductResponseDTO;
import com.ecommerce.ecommercebackend.entity.Product;
import com.ecommerce.ecommercebackend.service.ProductService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        Product saved = productService.saveProduct(product);

        return new ProductResponseDTO(saved.getId(), saved.getName(), saved.getPrice());
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts()
                .stream()
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getPrice()))
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        Product p = productService.getProductById(id);
        return new ProductResponseDTO(p.getId(), p.getName(), p.getPrice());
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        Product updated = productService.updateProduct(id, product);

        return new ProductResponseDTO(updated.getId(), updated.getName(), updated.getPrice());
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}