package in.vtech.springboot.web.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> findByUsername(String username) {
		List<Todo> todoList = this.todoRepository.findByUsername(username);
		return todoList;
	}

	public void addTodo(@Valid Todo todo) {
		this.todoRepository.save(todo);
	}

	public void deleteById(int id) {
		this.todoRepository.deleteById(id);
	}

	public void updateTodo(@Valid Todo todo) {
		this.todoRepository.save(todo);
	}

	public Todo findById(int id) {
		Todo todo = this.todoRepository.findById(id).get();
		return todo;
	}

}
