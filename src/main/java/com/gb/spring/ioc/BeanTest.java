package com.gb.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/person.xml");
		Creature c = ctx.getBean("person", Creature.class);
		c.useTool();
	}
}
