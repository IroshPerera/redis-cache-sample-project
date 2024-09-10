package com.webmotech.test_redis_with_springboot.controller;

import com.webmotech.test_redis_with_springboot.dto.VehicleDTO;
import com.webmotech.test_redis_with_springboot.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
@Slf4j
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/health")
    public String health() {
        return "Vehicle Service is up and running";
    }

    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        try {
            VehicleDTO responseDTO = vehicleService.saveVehicle(vehicleDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            log.error("An error occurred while saving the vehicle\n Exception: " + e.getMessage());
            return ResponseEntity.badRequest().body("An error occurred while saving the vehicle\n Exception: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateVehicle(@RequestBody VehicleDTO vehicleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        try {
            VehicleDTO responseDTO = vehicleService.updateVehicle(vehicleDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            log.error("An error occurred while updating the vehicle\n Exception: " + e.getMessage());
            return ResponseEntity.badRequest().body("An error occurred while updating the vehicle\n Exception: " + e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getVehicle(@RequestParam String vehicleId) {
        try {
            VehicleDTO responseDTO = vehicleService.getVehicle(vehicleId);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            log.error("An error occurred while getting the vehicle\n Exception: " + e.getMessage());
            return ResponseEntity.badRequest().body("An error occurred while getting the vehicle\n Exception: " + e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteVehicle(@RequestParam String vehicleId) {
        try {
            vehicleService.deleteVehicle(vehicleId);
            return ResponseEntity.ok("Vehicle deleted successfully");
        } catch (Exception e) {
            log.error("An error occurred while deleting the vehicle\n Exception: " + e.getMessage());
            return ResponseEntity.badRequest().body("An error occurred while deleting the vehicle\n Exception: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllVehicles() {
        try {
            return ResponseEntity.ok(vehicleService.getAllVehicles());
        } catch (Exception e) {
            log.error("An error occurred while getting all vehicles\n Exception: " + e.getMessage());
            return ResponseEntity.badRequest().body("An error occurred while getting all vehicles\n Exception: " + e.getMessage());
        }
    }


}
