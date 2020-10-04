package com.example.demo.resource.person;

import com.example.demo.model.dto.PersonRequestDTO;
import com.example.demo.model.dto.PersonResponseDTO;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")

@RequiredArgsConstructor
public class PersonResource {

    private final PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@Valid @RequestBody PersonRequestDTO request) {
        final PersonResponseDTO person = service.create(request);
        return ResponseEntity.created(URI.create("/api/v1/persons" + person.getId()))
            .body(person);
    }
}
