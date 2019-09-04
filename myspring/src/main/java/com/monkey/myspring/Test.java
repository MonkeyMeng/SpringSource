package com.monkey.myspring;


import com.monkey.myspring.parentandson.Son;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		TestBean testBean = annotationConfigApplicationContext.getBean(TestBean.class);
//		testBean.justDoIt();
		System.out.println("beanFactory:"+annotationConfigApplicationContext.getBeanFactory());

		ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext();
		((ClassPathXmlApplicationContext) xmlApplicationContext).setConfigLocations("spring.xml");
		((ClassPathXmlApplicationContext) xmlApplicationContext).setParent(annotationConfigApplicationContext);
		((ClassPathXmlApplicationContext) xmlApplicationContext).refresh();


		System.out.println((Son)(xmlApplicationContext.getBean("son")));

	}
}
