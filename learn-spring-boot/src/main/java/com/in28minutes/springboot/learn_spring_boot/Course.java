package com.in28minutes.springboot.learn_spring_boot;

public class Course {
	private int id;
	private String name, author;
	
	Course(int id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
}
