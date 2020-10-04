package com.example.demo.model.dto;

import com.example.demo.model.enumeration.PersonGenre;

import java.io.Serializable;

public class PersonResponseDTO implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private PersonGenre genre;
    private String github;

    public PersonResponseDTO() {
    }

    public PersonResponseDTO(String name, Integer age, PersonGenre genre, String github) {
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.github = github;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PersonGenre getGenre() {
        return genre;
    }

    public void setGenre(PersonGenre genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "PersonResponseDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", genre=" + genre +
            ", github='" + github + '\'' +
            '}';
    }
}
