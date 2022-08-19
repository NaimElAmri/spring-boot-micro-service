package com.naim.orderingsystem.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProductById(@PathVariable("id") UUID id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable("id") UUID id, @RequestBody Product productToUpdate) {
        productService.updateProduct(id, productToUpdate);
    }
}
