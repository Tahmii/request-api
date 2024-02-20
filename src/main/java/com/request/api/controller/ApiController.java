package com.request.api.controller;

import com.request.api.model.UserModelDTO;
import com.request.api.model.userAPI.ResultDTO;
import com.request.api.model.userAPI.UserDTO;
import com.request.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/random")
public class ApiController {

    private final ApiService apiService;

    ApiController(@Autowired ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping()
    public UserModelDTO getUserModel(){ return apiService.getUserRandom(); }

    @GetMapping("/list")
    public List<ResultDTO> getUserList(int nb){return apiService.multipleRandomUsers(nb);}
    
}
