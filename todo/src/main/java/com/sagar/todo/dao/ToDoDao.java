package com.sagar.todo.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoDao {
	private File file;
	public ToDoDao(){
		file = new File("/home/shaggyy28/Exercise/todo/src/main/resources/todo.db");
	}
	
	@SuppressWarnings("deprecation")
	public List<ToDo> getAllTodos()  throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		List<ToDo> list = new ArrayList<>();
		while(sc.hasNextLine()) {
			String[] split = sc.nextLine().split("\001");
			
			if(split.length == 2) {
				list.add(new ToDo(split[0], Status.valueOf(split[1])));
			}
		}
		sc.close();
		return list;
	}
	
	public void addTodo(ToDo todo) throws IOException {
		FileWriter writer = new FileWriter(file, true);
		writer.append(todo.toString());
		writer.close();
	}
	
	
	

}

