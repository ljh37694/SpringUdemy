package com.rest.webservices.restful_web_services.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class TodoResource {
	private TodoService todoService;
	
	public TodoResource(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping(path = "/users/{username}/todo-list")
	public List<Todo> retrieveTodoList(@PathVariable String username) {
		return todoService.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todo-list/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
		return todoService.findById(id);
	}
	
	@PostMapping("/users/{username}/todo-list")
	public Todo createTodo(@PathVariable String username, @Valid @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(
				username, todo.getDescription(), 
				todo.getTargetDate(), todo.isDone());
		
		System.out.println(todo);
		
		return createdTodo;
		
	}
	
	@DeleteMapping("/users/{username}/todo-list/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
		todoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todo-list/{id}")
	public Todo updateTodo(
			@PathVariable String username, 
			@PathVariable int id,
			@Valid @RequestBody Todo todo) {
		todoService.updateTodo(todo);
		
		System.out.println(todo);
		
		return todo;
	}
}
