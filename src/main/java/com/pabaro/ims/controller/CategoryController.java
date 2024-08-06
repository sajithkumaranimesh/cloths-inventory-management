package com.pabaro.ims.controller;

import com.pabaro.ims.dto.Category;
import com.pabaro.ims.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
