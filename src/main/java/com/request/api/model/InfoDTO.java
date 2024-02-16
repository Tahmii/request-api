package com.request.api.model;

import lombok.Data;

@Data
public class InfoDTO {
    private String seed;
    private int results;
    private int page;
    private String version;

}
