package com.sss.linkboard.service.client;


public class SignUpItem {

    /**
     * id : 294
     * remember_token : null
     * username : abc
     * updated_at : 2015-03-17 06:01:16
     * email : abc@yahoo.com
     * created_at : 2015-03-17 06:01:16
     */
    private String id;
    private String remember_token;
    private String username;
    private String updated_at;
    private String email;
    private String created_at;

    public void setId(String id) {
        this.id = id;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public String getUsername() {
        return username;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getEmail() {
        return email;
    }

    public String getCreated_at() {
        return created_at;
    }
}
