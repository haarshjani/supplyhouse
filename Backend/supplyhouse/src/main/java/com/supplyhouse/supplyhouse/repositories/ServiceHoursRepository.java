package com.supplyhouse.supplyhouse.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplyhouse.supplyhouse.models.ServiceHours;

@Repository
public interface ServiceHoursRepository  extends JpaRepository<ServiceHours, Long>{

    List<ServiceHours> findAllByActivServiceHours();
    
}
