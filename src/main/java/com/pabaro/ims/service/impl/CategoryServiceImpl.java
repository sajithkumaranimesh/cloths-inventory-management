package com.pabaro.ims.service.impl;

import com.pabaro.ims.dto.Category;
import com.pabaro.ims.entity.CategoryEntity;
import com.pabaro.ims.repository.CategoryJpaRepository;
import com.pabaro.ims.repository.CategoryRepository;
import com.pabaro.ims.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryJpaRepository jpaRepository;
    private final CategoryRepository repository;

    @Override
    public void persist(Category category) {
        jpaRepository.save(new ModelMapper().map(category, CategoryEntity.class));
    }

    @Override
    public List<Category> retrieveAll() {

        List<Category> categoryList = new ArrayList<>();

        List<CategoryEntity> categoryEntityList = repository.findAll();

        for (CategoryEntity categoryEntity : categoryEntityList){
            categoryList.add(new ModelMapper().map(categoryEntity, Category.class));
        }

        return categoryList;
    }
}
