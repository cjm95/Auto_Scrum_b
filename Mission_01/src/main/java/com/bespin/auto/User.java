package com.bespin.auto.domain;

public class User {
	private int num;
	private String name;
	private String team;
	private int age;
	private int curnum;
	
	public User() {}
	public User(int num, String name, String team, int age ) {
		this.num=num;
		this.name=name;
		this.team=team;
		this.age=age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", team=" + team + ", age=" + age + "]";
	}
	public int getCurnum() {
		return curnum;
	}
	public void setCurnum(int curnum) {
		this.curnum = curnum;
	}
	

}
