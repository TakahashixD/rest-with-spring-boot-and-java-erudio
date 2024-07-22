package br.com.takahashi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.takahashi.data.vo.v1.PersonVO;
import br.com.takahashi.services.PersonService;
import br.com.takahashi.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for managing people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all people", description = "Finds all people", 
	tags = {"People"},
	responses = {
			@ApiResponse(description="Success", responseCode = "200", content= {@Content(
					mediaType="application/json",
					array=@ArraySchema(schema=@Schema(implementation=PersonVO.class))
					)
			}),
			@ApiResponse(description="Bad Request", responseCode = "400", content= @Content),
			@ApiResponse(description="Unauthorized", responseCode = "401", content= @Content),
			@ApiResponse(description="Not Found", responseCode = "404", content= @Content),
			@ApiResponse(description="Internal Server Error", responseCode = "500", content= @Content),
	})
	public List<PersonVO> findAll() {
		return personService.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds a person", description = "Finds a person", 
	tags = {"People"},
	responses = {
			@ApiResponse(description="Success", responseCode = "200", content= @Content(schema=@Schema(implementation = PersonVO.class))),
			@ApiResponse(description="No Content", responseCode = "204", content= @Content),
			@ApiResponse(description="Bad Request", responseCode = "400", content= @Content),
			@ApiResponse(description="Unauthorized", responseCode = "401", content= @Content),
			@ApiResponse(description="Not Found", responseCode = "404", content= @Content),
			@ApiResponse(description="Internal Server Error", responseCode = "500", content= @Content),
	})
	public PersonVO findById(@PathVariable(value="id") Long id) {
		return personService.findById(id);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080", "https://erudio.com.br"})
	@PostMapping( 
			consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Create a new person", description = "Create a new person", 
	tags = {"People"},
	responses = {
			@ApiResponse(description="Created", responseCode = "200", content= @Content(schema=@Schema(implementation = PersonVO.class))),
			@ApiResponse(description="Bad Request", responseCode = "400", content= @Content),
			@ApiResponse(description="Unauthorized", responseCode = "401", content= @Content),
			@ApiResponse(description="Not Found", responseCode = "404", content= @Content),
			@ApiResponse(description="Internal Server Error", responseCode = "500", content= @Content),
	})
	public PersonVO create(@RequestBody PersonVO person) {		
		return personService.create(person);
	}
	
	@PutMapping( 
			consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Update a person", description = "Update a person", 
	tags = {"People"},
	responses = {
			@ApiResponse(description="Updated", responseCode = "200", content= @Content(schema=@Schema(implementation = PersonVO.class))),
			@ApiResponse(description="Bad Request", responseCode = "400", content= @Content),
			@ApiResponse(description="Unauthorized", responseCode = "401", content= @Content),
			@ApiResponse(description="Not Found", responseCode = "404", content= @Content),
			@ApiResponse(description="Internal Server Error", responseCode = "500", content= @Content),
	})
	public PersonVO update(@RequestBody PersonVO person) {		
		return personService.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete a person", description = "Delete a person", 
	tags = {"People"},
	responses = {
			@ApiResponse(description="No Content", responseCode = "204", content= @Content),
			@ApiResponse(description="Bad Request", responseCode = "400", content= @Content),
			@ApiResponse(description="Unauthorized", responseCode = "401", content= @Content),
			@ApiResponse(description="Not Found", responseCode = "404", content= @Content),
			@ApiResponse(description="Internal Server Error", responseCode = "500", content= @Content),
	})
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
