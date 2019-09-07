package com.prt.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prt.entity.VehicleInfoEntity;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleInfoEntity, String> {

    public Optional<VehicleInfoEntity> findByVehicleNumberIgnoreCase(String vehicleNumber);

    public Optional<VehicleInfoEntity> findByVehicleNumberIgnoreCaseAndUserId(String vehicleNumber, int userId);

    public List<VehicleInfoEntity> findByUserId(int userId);
}
