package br.com.takahashi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.takahashi.model.Person;

@Service
public class PersonService {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
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
	
	public Person create(Person person) {
		logger.info("create one person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("update one person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("delete one person");
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setGender("Male");
		person.setAddress("Some address in Brazil" + i);
		return person;
	}
}
