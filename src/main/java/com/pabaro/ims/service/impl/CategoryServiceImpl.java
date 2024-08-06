package com.pabaro.ims.service.impl;

import com.pabaro.ims.dto.Category;
import com.pabaro.ims.entity.CategoryEntity;
import com.pabaro.ims.repository.CategoryJpaRepository;
import com.pabaro.ims.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryJpaRepository jpaRepository;

    @Override
    public void persist(Category category) {
        jpaRepository.save(new ModelMapper().map(category, CategoryEntity.class));
    }
}
