package com.github.specht.batch.playground.repository;

import com.github.specht.batch.playground.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }
