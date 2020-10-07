package com.example.demo.model.dto;

import com.example.demo.model.enumeration.PersonGenre;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PersonRequestDTO implements Serializable {

    @NotNull
    @JsonProperty("nome_usuario")
    private String name;

    @NotNull
    @JsonProperty("idade_usuario")
    private Integer age;

    @NotNull
    @JsonProperty("sexo_do_usuario")
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
