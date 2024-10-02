package com.supplyhouse.supplyhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplyhouse.supplyhouse.models.ServiceHours;
import com.supplyhouse.supplyhouse.repositories.ServiceHoursRepository;

@Service
public interface ServiceHoursService {

    @Autowired
    ServiceHoursRepository serviceHoursRepository;

    List<ServiceHours> getAllByActivServiceHours();
    
}
