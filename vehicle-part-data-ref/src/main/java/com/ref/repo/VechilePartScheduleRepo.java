package com.ref.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ref.entity.VechilePartScheduleEntity;

@Repository
public interface VechilePartScheduleRepo extends JpaRepository<VechilePartScheduleEntity, Integer> {

    public List<VechilePartScheduleEntity> findByVechileModelVechileModelName(String name);

    @Query(value = "Select s from VechilePartScheduleEntity s where s.vechileModel.vechileModelName = :model")
    public List<VechilePartScheduleEntity> findVechilePartScheduleByModel(@Param("model") String name);

    @Query(value = "Select s from VechilePartScheduleEntity s where s.vechileModel.vechileModelName = :modelName "
	    + "and s.vechileModel.vechileCompany.vechileCompanyName = :companyName ")
    public List<VechilePartScheduleEntity> findVechilePartScheduleByModelAndCompany(
	    @Param("modelName") String modelName, @Param("companyName") String companyName);
}
