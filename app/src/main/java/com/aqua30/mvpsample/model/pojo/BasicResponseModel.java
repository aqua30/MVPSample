package com.aqua30.mvpsample.model.pojo;

/**
 * Created by Saurabh(aqua) on 24-03-2017.
 */

public class BasicResponseModel {

    private int status;
    private String code = "";
    private String user_id = "";
    private String token = "";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
