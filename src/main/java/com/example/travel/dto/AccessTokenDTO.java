package com.example.travel.dto;

import lombok.Data;

@Data
public class AccessTokenDTO {
    String client_id;
    String client_secret;
    String code;
    String redirect_uri;
    String state;
}
