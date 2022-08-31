package com.example.waiter.Api;


public class User {
    private String password;
    private String token;
    private String message;
    private String code;
    private String session_id;

    public User(String password, String session_id){
        this.password = password;
        this.session_id = session_id;
    }

    public String getPassword(){
        return password;
    }
    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }


}