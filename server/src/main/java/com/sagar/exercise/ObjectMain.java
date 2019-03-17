package com.sagar.exercise;


class String1 extends Object{
	String value;

	public String1(String value) {
		this.value = value;
	}
	
}


public class ObjectMain {
	public static void main(String[] args) {
		String1 obj = new String1("sagar");
		System.out.println(obj.toString());
	}
}
