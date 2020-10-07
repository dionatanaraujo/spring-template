package com.example.demo.resource;

import com.example.demo.DemoApplication;
import com.example.demo.model.dto.PersonRequestDTO;
import com.example.demo.model.enumeration.PersonGenre;
import com.example.demo.resource.person.PersonResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
@AutoConfigureMockMvc
public class PersonResourceTest {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    @MockBean
    private PersonResource resource;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder().setDateFormat("dd-MM-yyyy hh:mm:ss").create();
    }

    @Test
    public void should_get_all_persons() throws Exception {
        mockMvc.perform(get("/api/v1/persons")).andExpect(status().isOk());
    }

    @Test
    public void should_create_new_person() throws Exception {
        final PersonRequestDTO person = new PersonRequestDTO();
        person.setName("Dionatan Araújo");
        person.setAge(28);
        person.setGenre(PersonGenre.MALE);

        mockMvc.perform(post("/api/v1/persons")
            .content(gson.toJson(person)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void should_create_new_person_with_external_integration() throws Exception {

        final PersonExternalIntegrationRequestDTO externalIntegration = new PersonExternalIntegrationRequestDTO();
        externalIntegration.setNome_usuario("Dionatan Araújo");
        externalIntegration.setIdade_usuario(28);
        externalIntegration.setSexo_do_usuario(PersonGenre.MALE);

        final ObjectMapper mapper = new ObjectMapper();
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(PersonRequestDTO.class, new PersonExternalIntegrationRequestDeserializer());
        mapper.registerModule(module);

        final PersonRequestDTO person = mapper.readValue(gson.toJson(externalIntegration), PersonRequestDTO.class);

        mockMvc.perform(post("/api/v1/persons")
            .content(gson.toJson(person)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
