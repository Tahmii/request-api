package com.request.api.controller;

import com.request.api.model.UserDTO;
import com.request.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/random")
public class ApiController {

    private final ApiService apiService;

    ApiController(@Autowired ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping()
    public UserDTO getUser(){
        return apiService.userRandom();
    }
}
