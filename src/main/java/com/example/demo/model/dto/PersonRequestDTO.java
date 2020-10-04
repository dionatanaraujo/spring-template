package com.example.demo.model.dto;

import com.example.demo.model.enumeration.PersonGenre;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
public class PersonRequestDTO implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private PersonGenre genre;

    public PersonRequestDTO() {
    }

    public PersonRequestDTO(String name, Integer age, PersonGenre genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
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

    @Override
    public String toString() {
        return "PersonRequestDTO{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", genre=" + genre +
            '}';
    }
}
