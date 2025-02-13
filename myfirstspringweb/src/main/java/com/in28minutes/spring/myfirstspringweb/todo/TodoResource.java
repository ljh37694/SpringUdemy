package com.in28minutes.spring.myfirstspringweb.todo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	private TodoService todoService;
	
	public TodoResource(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping(path = "/users/{username}/todo-list")
	public List<Todo> retrieveTodoList(@PathVariable String username) {
		return todoService.findByUsername(username);
	}
}
