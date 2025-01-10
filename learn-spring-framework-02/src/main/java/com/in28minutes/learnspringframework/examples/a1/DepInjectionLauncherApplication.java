package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass{
	
//	@Autowired
	Dependency1 dependency1; //field based dependency injection
//	@Autowired
	Dependency2 dependency2;
	
	
	
	
	
	//setter based dependency injection
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter injection - Dependency1");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter injection - Dependency2");
//		this.dependency2 = dependency2;
//	}





	//constructor injection - Autowired is not mandatory
	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}





	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Using ");
		sb.append(dependency1+" and ");
		sb.append(dependency2);
		return sb.toString();
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//			System.out.println(context.getBeanDefinitionCount());
			System.out.println(context.getBean(YourBusinessClass.class));
		}
		
		
	}

}
