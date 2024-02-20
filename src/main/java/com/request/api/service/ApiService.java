package com.request.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.request.api.model.UserModelDTO;
import com.request.api.model.userAPI.ResultDTO;
import com.request.api.model.userAPI.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApiService {

    @Value("${app.urlApi}")
    private String urlApi;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    ApiService(@Autowired RestTemplate restTemplate,
               @Autowired ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public UserModelDTO transformToUserModelDTO(UserDTO userDTO) {
        UserModelDTO userModelDTO = new UserModelDTO();

        ResultDTO firstResult = userDTO.getResults().get(0);

        userModelDTO.setGender(firstResult.getGender());
        userModelDTO.setFirstName(firstResult.getName().getFirst());
        userModelDTO.setLastName(firstResult.getName().getLast());
        userModelDTO.setEmail(firstResult.getEmail());
        userModelDTO.setNat(firstResult.getNat());

        return userModelDTO;
    }



    public UserModelDTO getUserRandom(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlApi, String.class);
        String jsonResponse = responseEntity.getBody();

        try {
            UserDTO userDTO = objectMapper.readValue(jsonResponse, UserDTO.class);
            UserModelDTO response = transformToUserModelDTO(userDTO);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<ResultDTO> multipleRandomUsers(int numberOfUsers) {
        List<ResultDTO> userList = new ArrayList<>();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlApi + "?results=" + numberOfUsers, String.class);
        String jsonResponse = responseEntity.getBody();

        try {
            UserDTO userDTO = objectMapper.readValue(jsonResponse, UserDTO.class);
            userList = userDTO.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }


}
