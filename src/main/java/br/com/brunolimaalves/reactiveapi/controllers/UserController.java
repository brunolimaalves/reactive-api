package br.com.brunolimaalves.reactiveapi.controllers;

import br.com.brunolimaalves.reactiveapi.records.User;
import br.com.brunolimaalves.reactiveapi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<User>>> list() {
        Flux<User> users = repository.findAll();
        return Mono.just(ResponseEntity.ok(users));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<User>> create(@RequestBody User user) {
        return repository.save(user)
                .map(response -> ResponseEntity
                        .status(HttpStatus.CREATED).body(response));
    }
}
