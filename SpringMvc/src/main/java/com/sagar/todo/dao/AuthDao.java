package com.sagar.todo.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthDao {
	private static Map<String, String> authUser;
	public AuthDao(){
		Scanner sc = null;
		try {
			sc = new Scanner(new File("/home/shaggyy28/Exercise/todo/src/main/resources/auth.db"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ;
		authUser = new HashMap<>();
		while(sc.hasNextLine()) {
			String[] split = sc.nextLine().split("\001");
			
			if(split.length == 2) {
				authUser.put(split[0], split[0]);
			}
		}
		sc.close();
	}
	
	public boolean validateUser(String username, String password) {
		if(username == null || password == null) {
			return false;
		}
		return authUser.get(username) != null;
	}
	
	public boolean addUser(String username, String password){
		authUser.put(username, password);	
		PrintStream stream;
		try {
			stream = new PrintStream("/home/shaggyy28/Exercise/todo/src/main/resources/auth.db");
			stream.println(username + "\001" + password);
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
}
