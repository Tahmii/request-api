package com.request.api.model;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private List<ResultDTO> results;
    private InfoDTO info;
}
