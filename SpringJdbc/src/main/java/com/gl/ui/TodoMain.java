package com.gl.ui;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gl.beans.Todo;
import com.gl.config.JdbcConfig;
import com.gl.dao.TodoDao;
import com.gl.dao.TodoDaoImpl;

//controller
public class TodoMain 
{


	public static void main(String[] args)
	{
		ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
		TodoDao dao=context.getBean(TodoDaoImpl.class);

		
		//Todo todo = new Todo(1,"task1","task1 so and so");
//		Todo todo = new Todo(2,"task2","task2 so and so");
//		Todo todo1 = new Todo(3,"task3","task3 so and so");
//		Todo todo2 = new Todo(4,"task4","task4 so and so");

//		dao.saveTodo(todo);
//		dao.saveTodo(todo1);
//		dao.saveTodo(todo2);
//
//				Todo todo1 = new Todo(2,"task2","coding");
//				dao.updateTodo(todo1);
//
		//System.out.println(dao.getTodo(4));
		 dao.deleteTodo(4);


		 List<Todo> todos= dao.getAllTodos();
		for(Todo t:todos)
		{
			System.out.println(t);
		}





	}

}
