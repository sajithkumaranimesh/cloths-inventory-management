package com.pabaro.ims.repository;

import com.pabaro.ims.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<CategoryEntity> findAll();

    Optional<CategoryEntity> findById(Long id);

    void update(CategoryEntity categoryEntity);

    void deleteById(Long id);
}
