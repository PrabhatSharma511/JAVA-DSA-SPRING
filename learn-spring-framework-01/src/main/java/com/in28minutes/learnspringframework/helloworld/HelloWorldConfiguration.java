package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age,Adress adress) {};
record Adress(String firstLine, String City) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Prabhat";
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public Person person() {
		return new Person("Riya",24,new Adress("Baker street","Canada"));
	}
	
	
	//we can create beans reusing existing beans which are already managed by spring framework
	@Bean
	public Person person2MethodCall() {
		return new Person(name(),age(),adress());
	}
	
	@Bean
	@Primary
	public Person person3Parameters(String name,int age,Adress adress3) {
		return new Person(name,age,adress3);
	}
	
	@Bean
	public Person person4Parameters(String name,int age,@Qualifier("adressQualifier")Adress gtt) {
		return new Person(name,age,gtt);
	}
	
	@Bean(name = "customadressname")
	@Primary
	public Adress adress() {
		return new Adress("LP2","Saharanpur");
	}
	
	@Bean(name = "adress3")
	public Adress adress3() {
		return new Adress("Hanuman Chowk","Gurgaon");
	}
	
	@Bean
	@Qualifier("adressQualifier")
	public Adress adress4() {
		return new Adress("first line of adress","second line city");
	}
	

}
