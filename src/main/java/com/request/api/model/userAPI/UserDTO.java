package com.request.api.model.userAPI;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private List<ResultDTO> results;
    private InfoDTO info;
}
