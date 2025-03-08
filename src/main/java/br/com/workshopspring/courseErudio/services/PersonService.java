package br.com.workshopspring.courseErudio.services;

import br.com.workshopspring.courseErudio.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person...");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Romeo");
        person.setLastName("Gomes");
        person.setAddress("Rua 123");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all persons...");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Romeo - " + i);
        person.setLastName("Gomes - " + i);
        person.setAddress("Rua 123 - " + i);
        person.setGender("Male - " + i);
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person...");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person...");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person...");
    }
}
