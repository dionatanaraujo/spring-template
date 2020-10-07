package com.example.demo.resource;

import com.example.demo.Constants;
import com.example.demo.IntegrationTest;
import com.example.demo.model.dto.PersonRequestDTO;
import com.example.demo.model.enumeration.PersonGenre;
import com.example.demo.resource.person.PersonResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonResourceTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonResource resource;

    @Autowired
    @Qualifier("testObjectMapper")
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
    }

    @Test
    public void should_get_all_persons() throws Exception {
        mockMvc.perform(get("/api/v1/persons")).andExpect(status().isOk());
    }

    @Test
    public void should_create_new_person() throws Exception {
        final PersonRequestDTO person = new PersonRequestDTO();
        person.setName(Constants.VALID_PERSON_NAME);
        person.setAge(Constants.VALID_PERSON_AGE);
        person.setGenre(PersonGenre.MALE);

        mockMvc.perform(post("/api/v1/persons")
            .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(person)))
            .andDo(print())
            .andExpect(status().isOk());
    }

}
