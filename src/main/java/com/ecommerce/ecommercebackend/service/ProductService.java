package com.ecommerce.ecommercebackend.service;

import com.ecommerce.ecommercebackend.entity.Product;
import com.ecommerce.ecommercebackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return productRepository.save(product);
        }

        return null;
    }

    public String deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted";
        }
        return "Product not found";
    }
}