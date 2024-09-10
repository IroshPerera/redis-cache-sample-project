package com.webmotech.test_redis_with_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class VehicleEntity implements Serializable {
    @Id
    private String vehicleId;
    private String manufacturer;
    private String model;
    private int year;
    private String numberPlate;
    private String color;
}
