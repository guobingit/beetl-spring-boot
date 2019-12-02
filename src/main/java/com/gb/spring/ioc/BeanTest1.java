package com.gb.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/person1.xml");
		Creature c = ctx.getBean("person1", Creature.class);
		c.useTool();
	}
}
