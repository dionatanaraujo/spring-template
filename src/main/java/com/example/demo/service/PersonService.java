package com.example.demo.service;

import com.example.demo.converter.PersonResponseDTOConverter;
import com.example.demo.integration.client.v1.GithubClient;
import com.example.demo.integration.model.dto.GithubUserResponseDTO;
import com.example.demo.model.dto.PersonRequestDTO;
import com.example.demo.model.dto.PersonResponseDTO;
import com.example.demo.model.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.util.MessagesEnum.*;

@Service
public class PersonService {

    private final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private Messages messages;
    @Autowired
    private GithubClient githubClient;
    @Autowired
    private PersonRepository repository;

    public List<PersonResponseDTO> getAll() {
        log.debug(messages.get(FETCHING_ALL_PERSON));

        return repository.findAll()
            .stream()
            .map(person -> new PersonResponseDTOConverter().apply(person))
            .collect(Collectors.toList());
    }

    public PersonResponseDTO getOne(final Long id) {
        log.debug(messages.get(FETCHING_PERSON_BY_ID, id));

        final Optional<Person> person = repository.findById(id);
        return person.map(value -> new PersonResponseDTOConverter().apply(value)).orElse(null);
    }

    public PersonResponseDTO create(PersonRequestDTO dto) {
        log.debug(messages.get(CREATING_NEW_PERSON), dto);

        final Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setGenre(dto.getGenre());

        final GithubUserResponseDTO github = githubClient.getByUsername("dionatanaraujo");
        person.setGithub(github.getLogin());

        return new PersonResponseDTOConverter().apply(repository.save(person));
    }
}
