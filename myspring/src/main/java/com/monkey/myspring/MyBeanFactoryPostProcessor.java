package com.monkey.myspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out.println("beforeProcessBeanFactory...");
		Iterator<String> it = beanFactory.getBeanNamesIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("afterProcessBeanFactory...");
	}
}
