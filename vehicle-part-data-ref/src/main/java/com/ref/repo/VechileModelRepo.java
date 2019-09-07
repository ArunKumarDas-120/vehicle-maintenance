package com.ref.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ref.entity.VechileModelEntity;

@Repository
public interface VechileModelRepo extends JpaRepository<VechileModelEntity, Integer> {

    @Query(value = "select m from VechileModelEntity m where lower(m.vechileModelName) = lower(:modelName) and "
	    + "lower(m.vechileCompany.vechileCompanyName) = lower(:companyName) ")
    public List<VechileModelEntity> findModelByCompanyAndModel(@Param("modelName") String modelName,
	    @Param("companyName") String companyName);

    @Query(value = "select m from VechileModelEntity m where "
	    + "lower(m.vechileCompany.vechileCompanyName) = lower(:companyName) ")
    public List<VechileModelEntity> findModelByCompany(@Param("companyName") String companyName);
}
