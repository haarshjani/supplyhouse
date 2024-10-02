package com.supplyhouse.supplyhouse.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplyhouse.supplyhouse.models.ServiceHours;
import com.supplyhouse.supplyhouse.services.ServiceHoursService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/servicehours")
public class ServiceHoursController {


    @Autowired
    private ServiceHoursService serviceHoursService;

    /* URL GET /servicehours/list

       ===============================

     * Request json example{
     * 
     *  header:{
     *          "Content-Type": "application/json",
                "Authorization": "Bearer <token>"
     *      },
     * }
     * 
     * ===================================================
     * Responses json Example 
     * 
     * {
     *  status : "sucess",
     *  "statusCode": "200 ",
     *  "Content-Length": any Integer
        "Content-Type": "application/json"
     *  data : [LIST OF SERVICE HOURS ],
     *  
     * ]
     * 
     * }
     * 
     * {
     *  status : "Error",
     *  "statusCode": "500",
        "Content-Type": "application/json"
        "message" : "Server error from API"
        }

        {
     *  status : "Error",
     *  "statusCode": "401",
        "Content-Type": "application/json"
        "message" : "UnAuthorised"
        }
     * 
    */
    @GetMapping("path")
    public ResponseEntity<ServiceHours> getAllServiceHours() {
        return "serviceHours";
    }
    


    
}
