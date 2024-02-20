package com.request.api.model.userAPI;

import lombok.Data;

@Data

public class LocationDTO {
    private StreetDTO street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private CoordinatesDTO coordinates;
    private TimezoneDTO timezone;
}

