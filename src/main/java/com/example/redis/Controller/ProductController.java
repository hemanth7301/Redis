package com.example.redis.Controller;

import com.example.redis.Entity.Product;
import com.example.redis.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("{id}")
    public Product updateProductById(@PathVariable Long id,@RequestBody String name){
        return productService.updateProduct(new Product(id,name));
    }
}
