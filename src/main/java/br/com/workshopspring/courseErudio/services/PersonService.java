package br.com.workshopspring.courseErudio.services;

import br.com.workshopspring.courseErudio.models.Person;
import org.springframework.stereotype.Service;
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
}
