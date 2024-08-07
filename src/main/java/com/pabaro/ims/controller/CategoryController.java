package com.pabaro.ims.controller;

import com.pabaro.ims.dto.Category;
import com.pabaro.ims.service.CategoryService;
import lombok.RequiredArgsConstructor;
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
    public List<Category> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("/{id}")
    public Category retrieveById(@PathVariable Long id){
        return service.retrieveById(id);
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
