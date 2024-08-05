package com.pabaro.ims.repository;

import com.pabaro.ims.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierJpaRepository extends JpaRepository<SupplierEntity,Long> {
}
