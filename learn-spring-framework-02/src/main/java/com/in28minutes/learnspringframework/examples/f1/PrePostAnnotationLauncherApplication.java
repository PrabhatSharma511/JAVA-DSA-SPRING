package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;
	
	
	public SomeClass(SomeDependency someDependency) {
		
		super();
		this.someDependency=someDependency;
		System.out.println("All dependencies are ready"+someDependency);
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("Close all connections");
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some logic to initialize something using SomeDependency");
		
	}
	
	
}

@ComponentScan
public class PrePostAnnotationLauncherApplication {
	

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//			System.out.println(context.getBeanDefinitionCount());
		}
		
		
	}

}
