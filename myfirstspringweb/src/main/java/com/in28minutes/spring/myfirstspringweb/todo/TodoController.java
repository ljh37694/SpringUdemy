package com.in28minutes.spring.myfirstspringweb.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	public String addTodoPage(ModelMap model) {
		Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now(), false);
		
		model.put("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		
		todoService.addTodo((String)model.get("name"), todo.getDescription(), todo.getTargetDate(), false);
		
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoService.deleteById(id);
		
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.findById(id);
		
		model.addAttribute("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @RequestParam int id,
			@Valid Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addTodo";
		}
		
		todoService.updateTodo(todo);
		
		return "redirect:todo-list";
	}
}
