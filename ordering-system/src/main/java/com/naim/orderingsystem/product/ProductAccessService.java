package com.naim.orderingsystem.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository("Dao")
public class ProductAccessService implements ProductDao {

    private static List<Product> DB = new ArrayList<>();
 
    @Override
    public int insertProduct(UUID id, Product product) {
        DB.add(new Product(id, product.getName(), product.getType(), product.getDescription()));
        return 1;
    }

    @Override
    public List<Product> selectAllProducts() {
        return DB;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return DB.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteProductById(UUID id) {
        Optional<Product> productMaybe = selectProductById(id);
        if (productMaybe.isEmpty()){
            return 0;
        }
        DB.remove(productMaybe.get());
        return 1;
    }

    @Override
    public int updateProductById(UUID id, Product update) {
        return selectProductById(id).map(product -> {
            int indexofProductToUpdate = DB.indexOf(product);
            if (indexofProductToUpdate >= 0) {
                DB.set(indexofProductToUpdate, new Product(id, update.getName(), update.getType(), update.getDescription()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
    
}
