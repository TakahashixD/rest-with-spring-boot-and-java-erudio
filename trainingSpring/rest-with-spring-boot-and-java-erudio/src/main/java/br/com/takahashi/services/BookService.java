package br.com.takahashi.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.takahashi.controllers.BookController;
import br.com.takahashi.data.vo.v1.BookVO;
import br.com.takahashi.exceptions.RequiredObjectIsNullException;
import br.com.takahashi.exceptions.ResourceNotFoundException;
import br.com.takahashi.mapper.DozerMapper;
import br.com.takahashi.model.Book;
import br.com.takahashi.repositories.BookRepository;

@Service
public class BookService {
	private Logger logger = Logger.getLogger(BookService.class.getName());
	
	@Autowired
	BookRepository bookRepository;
	
	public List<BookVO> findAll() {
		logger.info("Finding all book");
		var books = DozerMapper.parseListObjects(bookRepository.findAll(), BookVO.class);
		books.stream()
			.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()) );;
		return books;
	}
	
	public BookVO findById(Integer id) {
		logger.info("Finding one book");
		var entity = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		BookVO vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public BookVO create(BookVO book) {
		if(book == null) throw new RequiredObjectIsNullException();
		logger.info("create one book");
		var entity = DozerMapper.parseObject(book, Book.class);
		BookVO vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public BookVO update(BookVO book) {
		logger.info("update one book");
		if(book == null) throw new RequiredObjectIsNullException();	
		var entity = bookRepository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Integer id) {
		logger.info("delete one book");
		Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		bookRepository.delete(entity);
	}
}
