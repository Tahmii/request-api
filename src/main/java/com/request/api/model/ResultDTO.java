package com.request.api.model;

import lombok.Data;

@Data
public class ResultDTO {
    private String gender;
    private NameDTO name;
    private LocationDTO location;
    private String email;
    private LoginDTO login;
    private DobDTO dob;
    private RegisteredDTO registered;
    private String phone;
    private String cell;
    private IdDTO id;
    private PictureDTO picture;
    private String nat;

    // Getters et Setters
}