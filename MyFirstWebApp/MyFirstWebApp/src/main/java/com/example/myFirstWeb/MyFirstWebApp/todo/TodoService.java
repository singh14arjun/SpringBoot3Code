package com.example.myFirstWeb.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<Todo>();
	
	private static int countTodo=0;
	
	static {
		todos.add(new Todo(++countTodo, "arjun", "Java", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo, "arjun", ".Net", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo, "arjun", "C++", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo, "arjun", "CSS3", LocalDate.now().plusYears(1), false));
	}

	
	
	public void addtodo(String userName,String description,LocalDate targetdate,boolean isDone) {
		Todo todo=new Todo(++countTodo, userName, description, targetdate, isDone);
	    todos.add(todo);
	}
	
	public void deleteById(int id) 
	{
		
		Predicate<? super Todo> predicate =todo ->todo.getId()==id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) 
	{
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
	   return todo;
	}

	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUserName().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void updateTodo(@Valid Todo todo) 
	{
		deleteById(todo.getId());
		todos.add(todo);
		
		
	}
	
	
}
