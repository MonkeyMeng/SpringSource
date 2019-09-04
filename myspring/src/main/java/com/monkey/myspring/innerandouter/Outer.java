package com.monkey.myspring.innerandouter;

public class Outer {

	private String name ="outer";

	private Inner inner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}
}
