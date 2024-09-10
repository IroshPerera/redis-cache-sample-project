package com.webmotech.test_redis_with_springboot.util.mapper;

import com.webmotech.test_redis_with_springboot.dto.VehicleDTO;
import com.webmotech.test_redis_with_springboot.entity.VehicleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GlobalMapper {

    VehicleEntity vehicleDTOtoVehicleEntity(VehicleDTO vehicleDTO);
    VehicleDTO vehicleEntityToVehicleDTO(VehicleEntity vehicleEntity);
    List<VehicleDTO> vehicleEntityListToVehicleDTOList(List<VehicleEntity> vehicleEntityList);
}
