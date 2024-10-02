package com.supplyhouse.supplyhouse.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "specialhours")
public class SpecialHours {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "startDate",unique = true)
    private LocalDate startDate;

    @Column(name = "endDate", unique = true)
    private LocalDate endDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @Column(name= "title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "isActive")
    private Boolean isActive;
    
}
