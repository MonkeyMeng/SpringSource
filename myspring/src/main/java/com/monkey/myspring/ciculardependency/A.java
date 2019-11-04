package com.monkey.myspring.ciculardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class A {

	@Autowired
	private B b;

	@Async
	public void a(){

		System.out.println(Thread.currentThread().getName());	;
	}

	@Async
	public void b(){

	}
}
