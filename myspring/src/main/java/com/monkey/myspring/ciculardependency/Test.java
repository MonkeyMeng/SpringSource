package com.monkey.myspring.ciculardependency;

import com.monkey.myspring.AppConfig;
import com.monkey.myspring.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {


	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);

//		A a = annotationConfigApplicationContext.getBean(A.class);
//		a.a();
	}
}
