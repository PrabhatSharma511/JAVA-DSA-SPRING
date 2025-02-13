package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessSerive{
	DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

//	@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter injection");
		this.dataService = dataService;
	}
	
	
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			System.out.println(context.getBean(BusinessSerive.class).getDataService());
		}
		
		
	}

}
