package com.request.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.request.api.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ApiService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    ApiService(@Autowired RestTemplate restTemplate,
               @Autowired ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public UserDTO userRandom(){

        String urlApi = "https://randomuser.me/api";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlApi, String.class);
        String jsonResponse = responseEntity.getBody();

        try {
            UserDTO userDTO = objectMapper.readValue(jsonResponse, UserDTO.class);

            return userDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
