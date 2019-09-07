package com.ref.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ref.entity.VechileCompanyEntity;

@Repository
public interface VechileCompanyRepo extends JpaRepository<VechileCompanyEntity, Integer> {

}
