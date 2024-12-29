package com.in28minutes.spring.myfirstspringweb.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todoList = new ArrayList<Todo>();
	
	static {
		todoList.add(new Todo(1, "name", "Learn spring", 
				LocalDate.now().plusYears(1), false));
		
		todoList.add(new Todo(2, "lee", "Learn react", 
				LocalDate.now().plusYears(1), true));
		
		todoList.add(new Todo(3, "park", "Learn cpp", 
				LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todoList;
	}
}
