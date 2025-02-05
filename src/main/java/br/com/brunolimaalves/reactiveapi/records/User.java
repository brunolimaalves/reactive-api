package br.com.brunolimaalves.reactiveapi.records;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record User (
        @Id Long id, @Column("username") String userName, String password, @Column("firstname") String firstName, @Column("lastname") String lastName ) {}

