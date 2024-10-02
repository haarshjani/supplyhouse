package com.supplyhouse.supplyhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplyhouse.supplyhouse.models.SpecialHours;
import com.supplyhouse.supplyhouse.repositories.SpecialHoursRepository;

@Service
public interface SpecialHoursService {

@Autowired 
SpecialHoursRepository specialHoursRepository;

List<SpecialHours> getAllSpecialHours();

SpecialHours saveSpecialHours(SpecialHours sphours);

SpecialHours updatSpecialHours(SpecialHours sphours, Long Id);

void deleteSpecialHours(Long id);
    
}
