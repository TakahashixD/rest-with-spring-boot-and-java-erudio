package br.com.takahashi.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.takahashi.model.Person;

@Service
public class PersonService {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding one person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Diego");
		person.setLastName("Takahashi");
		person.setGender("Male");
		person.setAddress("Maringá, PR");
		return person;
	}
}
