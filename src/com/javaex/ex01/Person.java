package com.javaex.ex01;

public class Person {

	// 필드
	private String name;
	private String hp;
	private String company;

	// 생성자
	public Person() {
	}

	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public Person(String name) {
		this.name = name;

	}

	// 메소드 - GS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// 메소드 - 일반
	public String showInfo() {
		return ".   " + name + "    " + hp + "    " + company;

	}

}
