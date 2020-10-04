package com.example.demo.integration.model.dto;

import java.io.Serializable;

public class GithubUserResponseDTO implements Serializable {

    private Long id;
    private String login;
    private String url;
    private String email;
    private String bio;
    private String name;

    public GithubUserResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GithubUserResponseDTO{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", url='" + url + '\'' +
            ", email='" + email + '\'' +
            ", bio='" + bio + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
