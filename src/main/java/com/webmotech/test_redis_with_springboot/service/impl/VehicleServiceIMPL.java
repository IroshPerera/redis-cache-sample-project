package com.webmotech.test_redis_with_springboot.service.impl;

import com.webmotech.test_redis_with_springboot.dto.VehicleDTO;
import com.webmotech.test_redis_with_springboot.entity.VehicleEntity;
import com.webmotech.test_redis_with_springboot.repository.VehicleRepository;
import com.webmotech.test_redis_with_springboot.service.VehicleService;
import com.webmotech.test_redis_with_springboot.util.mapper.GlobalMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceIMPL implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final GlobalMapper globalMapper;

    @Override
    @Cacheable(value = "vehicle", key = "#vehicleDTO.vehicleId")
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        log.info("Saving vehicle: {}", vehicleDTO);
        return globalMapper.vehicleEntityToVehicleDTO(vehicleRepository.save(globalMapper.vehicleDTOtoVehicleEntity(vehicleDTO)));
    }

    @Override
    @Cacheable(value = "vehicle", key = "#vehicleId")
    public VehicleDTO getVehicle(String vehicleId) {
        log.info("Getting vehicle with id: {}", vehicleId);
        vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        log.info("Vehicle found with id: {}", vehicleId);
        return vehicleRepository.findById(vehicleId).map(globalMapper::vehicleEntityToVehicleDTO).orElse(null);

    }

    @Override
    @Cacheable(value = "vehicle", key = "#vehicleDTO.vehicleId")
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        log.info("Updating vehicle: {}", vehicleDTO);
        VehicleEntity vehicleEntity = vehicleRepository.findById(vehicleDTO.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        log.info("Vehicle found with id: {}", vehicleDTO.getVehicleId());
        vehicleEntity.setVehicleId(vehicleDTO.getVehicleId());
        vehicleEntity.setYear(vehicleDTO.getYear());
        vehicleEntity.setManufacturer(vehicleDTO.getManufacturer());
        vehicleEntity.setModel(vehicleDTO.getModel());
        vehicleEntity.setColor(vehicleDTO.getColor());
        vehicleEntity.setNumberPlate(vehicleDTO.getNumberPlate());

        log.info("Vehicle updated with id: {}", vehicleDTO.getVehicleId());
        return globalMapper.vehicleEntityToVehicleDTO(vehicleRepository.save(vehicleEntity));


    }

    @Override
    @CacheEvict(value = "vehicle", key = "#vehicleId")
    public void deleteVehicle(String vehicleId) {

        log.info("Deleting vehicle with id: {}", vehicleId);
        vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        log.info("Vehicle found with id: {}", vehicleId);
        vehicleRepository.deleteById(vehicleId);
        log.info("Vehicle deleted with id: {}", vehicleId);
    }

    @Override
    @Cacheable(value = "vehicles")
    public List<VehicleDTO> getAllVehicles() {
        log.info("Getting all vehicles");
        return globalMapper.vehicleEntityListToVehicleDTOList(vehicleRepository.findAll());
    }
}
