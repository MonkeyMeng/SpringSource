package com.monkey.myspring;


import com.monkey.myspring.ciculardependency.A;
import com.monkey.myspring.parentandson.Son;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		System.out.println("hahs"+args[0]);
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		TestBean testBean = annotationConfigApplicationContext.getBean(TestBean.class);
		testBean.justDoIt();

		A a = annotationConfigApplicationContext.getBean(A.class);
		a.a();
//		System.out.println("beanFactory:"+annotationConfigApplicationContext.getBeanFactory());

//		ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext();
//		((ClassPathXmlApplicationContext) xmlApplicationContext).setConfigLocations("spring.xml");
//		((ClassPathXmlApplicationContext) xmlApplicationContext).setParent(annotationConfigApplicationContext);
//		((ClassPathXmlApplicationContext) xmlApplicationContext).refresh();
//
//
//		System.out.println((Son)(xmlApplicationContext.getBean("son")));


	}
}
