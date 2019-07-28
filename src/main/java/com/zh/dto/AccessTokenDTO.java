package com.zh.dto;

/**
 * @author xmr
 * @date 2019/7/27 17:55
 * @description
 */
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String rediret_uri;
    private String state;

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRediret_uri(String rediret_uri) {
        this.rediret_uri = rediret_uri;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getCode() {
        return code;
    }

    public String getRediret_uri() {
        return rediret_uri;
    }

    public String getState() {
        return state;
    }
}
