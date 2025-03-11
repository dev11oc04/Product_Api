package com.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product") // MongoDB collection name
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String Id; 
    private String productName;
    private String description;
    private double price;
    private int quantity;
}

