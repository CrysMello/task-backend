package br.ce.wcaquino.taskbackend.controlle;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {
	
	@Test
	public void naoDeveSalvarTrefaSemDescricao() throws ValidationException {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		TaskController controller = new TaskController();
		try {
		controller.save(todo);
		} catch (ValidationException e){
			Assert.assertEquals("Fill the task description", e.getMessage());
		}
	}
	
	@Test
	public void naoDeveSalvarTrefaSemData() {
		Task todo = new Task();
		todo.setTask("Desrição");
		TaskController controller = new TaskController();
		try {
		controller.save(todo);
		} catch (ValidationException e){
			Assert.assertEquals("Fill the due date", e.getMessage());
		}
		
	}
	
	@Test
	public void naoDeveSalvarTrefaComDataPassada() {
		Task todo = new Task();
		todo.setTask("Desrição");
		todo.setDueDate(LocalDate.of(2010, 01, 01));
		TaskController controller = new TaskController();
		try {
		controller.save(todo);
		} catch (ValidationException e){
			Assert.assertEquals("Due date must not be in past", e.getMessage());
		}
		
	}
	
};