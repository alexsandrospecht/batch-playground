package com.github.specht.batch.playground.batch.process.person;

import com.github.specht.batch.playground.model.Person;
import lombok.extern.java.Log;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Log
@Component
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = Person.builder().
                firstName(firstName).lastName(lastName).build();

        log.info(format("Converting (%s) into (%s)", person, transformedPerson));

        // Heavy work
        Thread.sleep(1000);

        return transformedPerson;
    }

}