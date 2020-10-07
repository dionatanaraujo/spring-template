package com.example.demo.resource;

import com.example.demo.model.dto.PersonRequestDTO;
import com.example.demo.model.enumeration.PersonGenre;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;

public class PersonExternalIntegrationRequestDeserializer extends StdDeserializer<PersonRequestDTO> {

    public PersonExternalIntegrationRequestDeserializer() {
        this(null);
    }

    protected PersonExternalIntegrationRequestDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PersonRequestDTO deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException, JsonProcessingException {
        final PersonRequestDTO person = new PersonRequestDTO();
        ObjectCodec codec = parser.getCodec();
        JsonNode nodes = codec.readTree(parser);

        person.setName(nodes.get("nome_usuario").toString());
        person.setAge(((IntNode) nodes.get("idade_usuario")).numberValue().intValue());
        person.setGenre(PersonGenre.valueOf(nodes.get("sexo_do_usuario").toString().replaceAll("\"", "")));
        return person;
    }
}
