package com.webmotech.test_redis_with_springboot.service;

import com.webmotech.test_redis_with_springboot.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicle(String vehicleId);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicleId);
    List<VehicleDTO> getAllVehicles();

}
