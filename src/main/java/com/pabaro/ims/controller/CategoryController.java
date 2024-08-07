package com.pabaro.ims.controller;

import com.pabaro.ims.dto.Category;
import com.pabaro.ims.dto.SuccessResponse;
import com.pabaro.ims.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping()
    public void persist(@RequestBody Category category){
        service.persist(category);
    }

    @GetMapping()
    public ResponseEntity<SuccessResponse> retrieveAll(){
        List<Category> categoryList = service.retrieveAll();
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(categoryList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> retrieveById(@PathVariable Long id){
        Category category = service.retrieveById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(category)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @PutMapping()
    public void update(@RequestBody Category category){
        service.update(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
