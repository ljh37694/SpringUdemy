package com.rest.webservices.restful_web_services.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {
	private TodoService todoService;
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}

	@RequestMapping("todo-list")
	public String todoListPage(ModelMap model) {
		String username = getLoggedinUsername();
		List<Todo> todoList = todoRepository.findByUsername(username);
		
		model.addAttribute("todoList", todoList);
		
		return "todoList";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
		Todo todo = new Todo(0, getLoggedinUsername(), "", LocalDate.now(), false);
		
		model.put("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		
		todo.setUsername(getLoggedinUsername());
		todoRepository.save(todo);
		
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoRepository.deleteById(id);
		
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = todoRepository.findById(id).get();
		
		model.addAttribute("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		
		todo.setUsername(getLoggedinUsername());
		todoRepository.save(todo);
		
		return "redirect:todo-list";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
}
