package com.example.demo.integration.client.v1;

import com.example.demo.integration.model.dto.GithubUserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://api.github.com", name = "github.client")
public interface GithubClient {

    @GetMapping("/users/{username}")
    GithubUserResponseDTO getByUsername(@PathVariable("username") String username);
}
