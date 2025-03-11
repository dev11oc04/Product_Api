package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all employees
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get employee by ID
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Add new employee
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update employee
    public Product updateProduct(String id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id); // Ensure the ID remains unchanged
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    // Delete employee
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}

