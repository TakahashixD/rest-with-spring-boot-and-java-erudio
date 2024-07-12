package br.com.takahashi.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.takahashi.exceptions.ResourceNotFoundException;
import br.com.takahashi.model.Person;
import br.com.takahashi.repositories.PersonRepository;

@Service
public class PersonService {
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> findAll() {
		logger.info("Finding all person");
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person");
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("create one person");
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("update one person");
		Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("delete one person");
		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		personRepository.delete(entity);
	}

}
