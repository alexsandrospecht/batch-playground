package com.github.specht.batch.playground.batch.process.person;

import com.github.specht.batch.playground.model.Person;
import com.github.specht.batch.playground.repository.PersonRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonItemWriter implements ItemWriter<Person> {

    @Autowired
    private PersonRepository repository;

    @Override
    public void write(List<? extends Person> persons) {
        repository.saveAll(persons);
    }
}
