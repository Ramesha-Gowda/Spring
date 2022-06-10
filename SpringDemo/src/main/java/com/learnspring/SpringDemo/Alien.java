package com.learnspring.SpringDemo;

public class Alien {
	
	
	private int age = 18;
	
	private Computer comp;

	public Alien(int age) {
		this.age = age;
	}
	//default constructor
	public Alien() {
		System.out.println("Alien Object Created..");
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("Age Assigned..");
		this.age = age;
	}
	
	public Computer getComp() {
		return comp;
	}
	public void setComp(Computer comp) {
		this.comp = comp;
	}
	public void code() {
		System.out.println("I'm Coding..");
		comp.compile();
	}
}
