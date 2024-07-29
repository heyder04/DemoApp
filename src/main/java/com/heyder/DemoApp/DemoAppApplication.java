package com.heyder.DemoApp;

import com.heyder.DemoApp.contollers.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAppApplication {
	@Autowired
	private Test t;






	public static void main(String[] args) {
        final Test test;
        final Test test2;
		ApplicationContext ac=SpringApplication.run(DemoAppApplication.class, args);
        Test t1=ac.getBean(Test.class);
        Test t2=ac.getBean(Test.class);
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());

	}

}
