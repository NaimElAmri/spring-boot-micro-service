package com.naim.orderingsystem.product;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private UUID id;
    private String name;
    private String type;
    private String description;
    
    public Product() {
    }

    public Product(@JsonProperty("id") UUID id,@JsonProperty("name") String name,@JsonProperty("type") String type,@JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Product(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [description=" + description + ", id=" + id + ", name=" + name + ", type=" + type + "]";
    }

    
    
}

