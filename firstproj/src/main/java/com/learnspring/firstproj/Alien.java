package com.learnspring.firstproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	@Autowired
	Laptop lap;	int age=18;
	
	public void code() {
		lap.compile();
	}

}
