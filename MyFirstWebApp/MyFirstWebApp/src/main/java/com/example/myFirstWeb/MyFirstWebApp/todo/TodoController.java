package com.example.myFirstWeb.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	private String getLoggedInUsername(ModelMap model) {
		return (String) model.get("name");
	}

	@GetMapping("/list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@GetMapping("/add-todo")
	public String showAddTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "",LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername(model);
		todoService.addtodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:/list-todos";
	}

	@GetMapping("/update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "UpdateTodo";
	}

	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "UpdateTodo";
		}
		String username = getLoggedInUsername(model);
		todo.setUserName(username);
		
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}

}
