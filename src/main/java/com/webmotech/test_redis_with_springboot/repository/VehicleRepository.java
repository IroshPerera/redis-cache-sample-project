package com.webmotech.test_redis_with_springboot.repository;

import com.webmotech.test_redis_with_springboot.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity,String> {
}
