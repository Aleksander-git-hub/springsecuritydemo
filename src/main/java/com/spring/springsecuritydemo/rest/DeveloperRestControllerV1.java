package com.spring.springsecuritydemo.rest;

import com.spring.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/api/v1")
public class DeveloperRestControllerV1 {

    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Peter", "Parker"),
            new Developer(3L, "Tony", "Stark")
    ).collect(Collectors.toList());

    @GetMapping(value = "/developers")
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping(value = "/developer/{developerId}")
    public Developer getById(@PathVariable(value = "developerId") Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping(value = "/new_developer")
    public Developer create(Developer developer) {
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping(value = "/developer/{developerId}")
    public void deleteById(@PathVariable(value = "developerId") Long id) {
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
