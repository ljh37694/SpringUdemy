package com.learn_spring_security.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class TodoResource {
	private static final List<Todo> TODO_LIST = List.of(
			new Todo("admin", "Learn React"),
			new Todo("Halland", "Learn Mang")
			);
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return TODO_LIST;
	}
	
	@GetMapping("/users/{username}/todos")
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("returnObject.username == 'admin'")
	@RolesAllowed({"ADMIN", "USER"})
	public Todo retrieveTodosForSpecificUser(@PathVariable(name = "username") String username) {
		return TODO_LIST.get(0);
	}
	
	@PostMapping("/users/{username}/todos")
	public void createTodoForSpecificUser(@PathVariable(name = "username") String username, @RequestBody Todo todo) {
		logger.info("Create {} for {}", todo, username);
	}
}

record Todo(String username, String description) {}