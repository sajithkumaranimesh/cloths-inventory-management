package com.pabaro.ims.repository;

import com.pabaro.ims.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository {
    List<CategoryEntity> findAll();
}
