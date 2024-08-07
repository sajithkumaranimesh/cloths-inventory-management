package com.pabaro.ims.controller;

import com.pabaro.ims.dto.Product;
import com.pabaro.ims.dto.SuccessResponse;
import com.pabaro.ims.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SuccessResponse> retrieveAll(){
        List<Product> productList = service.retrieveAll();
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(productList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> retrieveById(@PathVariable Long id){
        Product product = service.retrieveById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(product)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @PutMapping()
    public void update(@RequestBody Product product){
        service.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
