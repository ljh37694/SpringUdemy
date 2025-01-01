package com.in28minutes.spring.myfirstspringweb.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todoList = new ArrayList<Todo>();
	
	private static int todoCount = 0;
	
	static {
		todoList.add(new Todo(++todoCount, "name", "Learn spring", 
				LocalDate.now().plusYears(1), false));
		
		todoList.add(new Todo(++todoCount, "lee", "Learn react", 
				LocalDate.now().plusYears(2), true));
		
		todoList.add(new Todo(++todoCount, "park", "Learn cpp", 
				LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todoList;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		todoList.add(new Todo(++todoCount, username, description, targetDate, done));
	}
}
