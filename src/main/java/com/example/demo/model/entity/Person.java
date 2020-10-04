package com.example.demo.model.entity;

import com.example.demo.model.enumeration.PersonGenre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @Enumerated(EnumType.STRING)
    private PersonGenre genre;

    private String github;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", genre=" + genre +
            ", github='" + github + '\'' +
            '}';
    }
}
