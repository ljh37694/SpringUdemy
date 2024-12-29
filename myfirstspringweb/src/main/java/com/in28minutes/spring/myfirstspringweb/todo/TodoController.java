package com.in28minutes.spring.myfirstspringweb.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}


	@RequestMapping("todo-list")
	public String todoListPage(ModelMap model) {
		List<Todo> todoList = todoService.findByUsername("name");
		
		model.put("todoList", todoList);
		
		return "todoList";
	}
}
