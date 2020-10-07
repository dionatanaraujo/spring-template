package com.example.demo.resource;

import com.example.demo.model.enumeration.PersonGenre;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PersonExternalIntegrationRequestDeserializer.class)
public class PersonExternalIntegrationRequestDTO {

    private String nome_usuario;

    private Integer idade_usuario;

    private PersonGenre sexo_do_usuario;

    public PersonExternalIntegrationRequestDTO() {
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public Integer getIdade_usuario() {
        return idade_usuario;
    }

    public void setIdade_usuario(Integer idade_usuario) {
        this.idade_usuario = idade_usuario;
    }

    public PersonGenre getSexo_do_usuario() {
        return sexo_do_usuario;
    }

    public void setSexo_do_usuario(PersonGenre sexo_do_usuario) {
        this.sexo_do_usuario = sexo_do_usuario;
    }

    @Override
    public String toString() {
        return "PersonExternalIntegrationRequestDTO{" +
            "nome_usuario='" + nome_usuario + '\'' +
            ", idade_usuario=" + idade_usuario +
            ", sexo_do_usuario=" + sexo_do_usuario +
            '}';
    }
}
