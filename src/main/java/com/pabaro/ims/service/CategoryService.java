package com.pabaro.ims.service;

import com.pabaro.ims.dto.Category;

import java.util.List;

public interface CategoryService {
    void persist(Category category);

    List<Category> retrieveAll();

    Category retrieveById(Long id);

    void update(Category category);
}
