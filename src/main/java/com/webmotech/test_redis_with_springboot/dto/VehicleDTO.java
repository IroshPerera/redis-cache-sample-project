package com.webmotech.test_redis_with_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO implements Serializable {
    private String vehicleId;
    private String manufacturer;
    private String model;
    private int year;
    private String numberPlate;
    private String color;
}
