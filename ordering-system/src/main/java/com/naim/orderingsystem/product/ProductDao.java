package com.naim.orderingsystem.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {
    
    int insertProduct(UUID id, Product product);

    default int insertProduct(Product product) {
        UUID id = UUID.randomUUID();
        return insertProduct(id, product);
    }

    List<Product> selectAllProducts();

    Optional<Product> selectProductById(UUID id);

    int deleteProductById(UUID id);

    int updateProductById(UUID id, Product product);
}
