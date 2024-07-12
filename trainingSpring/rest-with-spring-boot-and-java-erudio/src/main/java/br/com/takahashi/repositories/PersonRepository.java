package br.com.takahashi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.takahashi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
