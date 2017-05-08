package eu.zeigermann.nashorn.databinding;

import java.util.Date;

public class User {
	
	private String name;
	public Integer age;
	public Date birthday;  
	public String birthday2;  

	public User(String name, Integer age, Date birthday, String birthday2) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.birthday2 = birthday2;
	}
	
	public String getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(String birthday2) {
		this.birthday2 = birthday2;
	}




	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
