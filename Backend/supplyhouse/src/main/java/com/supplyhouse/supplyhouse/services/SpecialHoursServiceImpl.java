package com.supplyhouse.supplyhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.supplyhouse.supplyhouse.models.SpecialHours;
import com.supplyhouse.supplyhouse.repositories.SpecialHoursRepository;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class SpecialHoursServiceImpl implements SpecialHoursService {

  
    @Autowired
    
    //Implementation and business logic for service class

    @Override
    public SpecialHours saveSpecialHours(SpecialHours specialHours){
            //business logic to save 
    }
}
