package com.in28minutes.spring.myfirstspringweb.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
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
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodoPage() {
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model) {
		todoService.addTodo((String)model.get("name"), description, LocalDate.now(), false);
		
		return "redirect:todo-list";
	}
}
