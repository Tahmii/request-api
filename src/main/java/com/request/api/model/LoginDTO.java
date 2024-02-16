package com.request.api.model;

import lombok.Data;

@Data
public class LoginDTO {
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

}

