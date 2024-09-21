package com.example.redis.Service;

import com.example.redis.Entity.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Long id) {
        simulateSlowService();
        return new Product(id, "Product-" + id);
    }

    @CachePut(value = "product", key = "#product.id")
    public Product updateProduct(Product product) {
        return product;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
