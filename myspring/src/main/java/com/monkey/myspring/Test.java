package com.monkey.myspring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		TestBean testBean = annotationConfigApplicationContext.getBean(TestBean.class);
		testBean.justDoIt();

	}
}
