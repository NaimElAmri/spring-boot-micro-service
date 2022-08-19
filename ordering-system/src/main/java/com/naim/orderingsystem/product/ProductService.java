package com.naim.orderingsystem.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("Dao") ProductDao productDao) {
        this.productDao = productDao;
    }

    public int addProduct(Product product) {
        return productDao.insertProduct(product); 
    }

    public List<Product> getAllProducts() {
        return productDao.selectAllProducts();
    }

    public Optional<Product> getProductById(UUID id) {
        return productDao.selectProductById(id);
    }

    public int deleteProduct(UUID id) {
        return productDao.deleteProductById(id);
    }

    public int updateProduct(UUID id, Product newProduct) {
        return productDao.updateProductById(id, newProduct);
    }
   
}
