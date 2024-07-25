package com.springBoot.TodosApplication.Todo;

import java.time.LocalDate;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
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

	@RequestMapping("list-todos")
	public String ListAllTodos(ModelMap model) {
		String username = getLoggedInUserName(model);
		List<Todo> todos = todoService.findByuserName(username);
		model.addAttribute("todos", todos);
		return "ListTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUserName(model);

		Todo todo = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "Todo";
	}

	

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "Todo";
		}
		String username = getLoggedInUserName(model);
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);

		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showupdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "Todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "Todo";
		}
		String username = getLoggedInUserName(model);
		todo.setUserName(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	private String getLoggedInUserName(ModelMap model) {
		return (String) model.get("name");
	}
}
