package com.proiectcolectiv.proiect.entities;

public class AuthToken {

    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private Long id;

    public AuthToken(String accessToken, String username, Long id) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
