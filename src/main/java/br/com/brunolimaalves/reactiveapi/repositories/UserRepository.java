package br.com.brunolimaalves.reactiveapi.repositories;

import br.com.brunolimaalves.reactiveapi.records.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
