package com.supplyhouse.supplyhouse.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplyhouse.supplyhouse.models.SpecialHours;
import com.supplyhouse.supplyhouse.services.SpecialHoursService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/specialhours")
public class SpecialHoursController {

    @Autowired
    public SpecialHoursService specialHoursService;

    /* HTTP Method : GET
       URL   : /specialhours/list

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
     *  data : [{
     *      "id" : "uuidv4",
            "startDate" : "2024-10-03",
            "endDate" :  "2024-10-12",
            "startTime" : "08:45:000",
            "endTime" : "19:45:000",
            "title" : "Questions?",
            "description" : "Our Customer support will be opening late today . We appologize for any inconvenience",
            "isActive" : "true"
     *  },
     *  OTHER LIST OF SPECIAL HOURS 
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

    @GetMapping("/list")
    public ResponseEntity getAllSpecialHours() {
         return "" ;
    }

    /*
        HTTP Method : POST
        URL :  /specialhours/add
        
        ==================================

        Request json example : {
            header:{
     *          "Content-Type": "application/json",
                "Authorization": "Bearer <token>"
     *      },
     *       body : {
     *          
                "startDate" : "2024-12-25",
                "endDate" :  "2024-12-31",
                "startTime" : "08:45:000",
                "endTime" : "16:45:000",
                "title" : "Questions?",
                "description" : "Our Customer support will be opening late today . We appologize for any inconvenience",
                "isActive" : "true"
        *      }
        }
        =======================================

        Response json Example {
     *  status : "Created",
     *  "statusCode": "201",
     *  "Content-Length": any Integer
        "Content-Type": "application/json"
     *  "message" : "Special hours Added"
     *  data : {
     *      "id" : "E.g uuidv4",
            "startDate" : "2024-10-03",
            "endDate" :  "2024-10-12",
            "startTime" : "08:45:000",
            "endTime" : "19:45:000",
            "title" : "Questions?",
            "description" : "Our Customer support will be opening late today . We appologize for any inconvenience",
            "isActive" : "true"
     *  }
     * }
     * {
     *  status : "Error",
     *  "statusCode": "500",
        "Content-Type": "application/json"
        "message" : "Date already exists"
        }
     * {
     *  status : "Error",
     *  "statusCode": "500",
        "Content-Type": "application/json"
        "message" : "Server error "
        }

        {
     *  status : "Error",
     *  "statusCode": "401",
        "Content-Type": "application/json"
        "message" : "UnAuthorised"
        }
     * 
    */ 
    @PostMapping("/add")
    public ResponseEntity addSpecialHours(@RequestBody SpecialHours spHours) {
        
        return "joson with special hour created with  generated new id and status created 201";
    }


    /*  HTTP Method : PUT
        URL :  /specialhours/update/UUID
        
        ==================================

        Request json example : {
            header:{
     *          "Content-Type": "application/json",
                "Authorization": "Bearer <token>"
     *      },
     *       params : {
     *          id : "UUID"
     *      }
     *      body : {
     *           "isActive" : "False" (Update)
     *      }
        }
      =======================================
        Response json Example {
     *  status : "OK",
     *  "statusCode": "200",
     *  "Content-Length": any Integer
        "Content-Type": "application/json"
     *  "message" : "Special hours updated"
     *  data : {
     *      "id" : "E.g uuidv4",
            "startDate" : "2024-10-03",
            "endDate" :  "2024-10-12",
            "startTime" : "08:45:000",
            "endTime" : "19:45:000",
            "title" : "Questions?",
            "description" : "Our Customer support will be opening late today . We appologize for any inconvenience",
            "isActive" : "False" (Updated)
     *  }
     * }
     * {
     *  status : "Error",
     *  "statusCode": "404",
        "Content-Type": "application/json"
        "message" : "Requested Special hours not found "
        }
     * {
     *  status : "Error",
     *  "statusCode": "500",
        "Content-Type": "application/json"
        "message" : "Internal Server error  "
        }

        {
     *  status : "Error",
     *  "statusCode": "401",
        "Content-Type": "application/json"
        "message" : "UnAuthorised"
        }
     * 
    */
    @PutMapping("/update/{id}")
    public ResponseEntity updateSpacialHours(@RequestBody  SpecialHours spHours,@PathVariable String id) {
      
        
        return "Json Updated special hour with status OK";
    }

    /*  HTTP Method : DELETE
        URL :  /specialhours/remove/uuid
        
        ==================================

        Request json example : {
            header:{
     *          "Content-Type": "application/json",
                "Authorization": "Bearer <token>"
     *      },
     *       params : {
     *          id : "UUID"
     *      }
        }
      =======================================
        Responses json Example 
        {
     *  status : "OK",
     *  "statusCode": "200",
     *  "Content-Length": any Integer
        "Content-Type": "application/json"
     *  "message" : "Special hours deleted"
     *  
     * }
     * {
     *  status : "Error",
     *  "statusCode": "404",
        "Content-Type": "application/json"
        "message" : "Requested Special hours not found "
        }
     * {
     *  status : "Error",
     *  "statusCode": "500",
        "Content-Type": "application/json"
        "message" : "Internal Server error "
        }

        {
     *  status : "Error",
     *  "statusCode": "401",
        "Content-Type": "application/json"
        "message" : "UnAuthorised"
        }
     * 
    */
    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeSpecialHours(@PathVariable String id){
         return ResponseEntity;
    }
    
    
    
}
