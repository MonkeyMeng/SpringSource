package com.monkey.myspring.parentandson;

import org.springframework.stereotype.Component;

@Component
public class Son {

	private String name;

	private String age;


	private String nation="china";

	private String sex;

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	private String hobbit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHobbit() {
		return hobbit;
	}

	public void setHobbit(String hobbit) {
		this.hobbit = hobbit;
	}

	@Override
	public String toString() {
		return "Son{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				", nation='" + nation + '\'' +
				", sex='" + sex + '\'' +
				", hobbit='" + hobbit + '\'' +
				'}';
	}
}
