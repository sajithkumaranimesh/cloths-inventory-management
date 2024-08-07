package com.pabaro.ims.repository;

import com.pabaro.ims.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity,Long> {
}
