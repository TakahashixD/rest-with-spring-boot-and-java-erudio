package br.com.takahashi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.takahashi.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
