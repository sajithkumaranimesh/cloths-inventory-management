package com.pabaro.ims.controller;

import com.pabaro.ims.dto.Product;
import com.pabaro.ims.entity.ProductEntity;
import com.pabaro.ims.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public void persist(@RequestBody Product product){
        service.persist(product);
    }

    @GetMapping()
    public List<Product> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("/{id}")
    public Product retrieveById(@PathVariable Long id){
        return service.retrieveById(id);
    }
}
