package com.zh.dto;

/**
 * @author xmr
 * @date 2019/7/27 21:49
 * @description
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }
}
