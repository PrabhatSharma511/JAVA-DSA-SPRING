package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		//1. Launch a spring context
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			//2.Configure the things that we want spring to manage - @Configuration
			//things we did in HelloWorldConfiguration class
			
			
			//3. Retrieving the beans managed by spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("person")); //retrieving bean by fn name
			System.out.println(context.getBean("person2MethodCall"));//using other beans to fetch data for a bean
			System.out.println(context.getBean("customadressname")); //retrieving bean by name
			System.out.println(context.getBean(Adress.class)); //retrieving bean by type
			System.out.println(context.getBean(Person.class));
			System.out.println((context.getBean("person3Parameters")));
			System.out.println(context.getBeanDefinitionCount());
			System.out.println(context.getBean("person4Parameters"));
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		;
		
	}

}
