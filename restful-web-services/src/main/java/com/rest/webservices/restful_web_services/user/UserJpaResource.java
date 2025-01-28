package com.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	private UserRepository repository;
	
	public UserJpaResource(UserRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		
		EntityModel<Optional<User>> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
}
