package com.gb.spring.ioc;

/**
 * 构造注入
 * 构造注入是IoC容器使用构造器来注入被依赖对象
 */
public class Person1 implements Creature {
	private Eye eye;
	private Hand hand;
	
	public Person1(Eye eye, Hand hand) {
		this.eye = eye;
		this.hand = hand;
	}
	
	@Override
	public void useTool() {
		System.out.println(eye.read());
		System.out.println(hand.write());
	}
}
