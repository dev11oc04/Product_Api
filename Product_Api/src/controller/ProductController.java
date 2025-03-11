package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("*") // Enable CORS for frontend integration
public class ProductController {

    @Autowired
    private ProductService employeeService;

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Product>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllProducts());
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getEmployeeById(@PathVariable String id) {
        Optional<Product> employee = employeeService.getProductById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new employee
    @PostMapping
    public ResponseEntity<Product> addEmployee(@RequestBody Product employee) {
        return ResponseEntity.ok(employeeService.addProduct(employee));
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateEmployee(@PathVariable String id, @RequestBody Product updatedEmployee) {
        Product employee = employeeService.updateProduct(id, updatedEmployee);
        return (employee != null) ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        employeeService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

