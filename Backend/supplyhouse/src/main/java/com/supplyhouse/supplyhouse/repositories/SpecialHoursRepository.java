package com.supplyhouse.supplyhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplyhouse.supplyhouse.models.SpecialHours;
import java.util.List;
import java.util.Optional;


@Repository
public interface SpecialHoursRepository extends JpaRepository<SpecialHours, Long >{

    Optional<SpecialHours> findById(Long id);
    List<SpecialHours> findAll();
    

}