package com.gb.spring.ioc;

/**
 * 设值注入
 * 设值注入是IoC容器使用成员变量的setter方法来注入被依赖对象
 */
public class Person implements Creature {
	
	private Eye eye;
	private Hand hand;
	
	@Override
	public void useTool() {
		System.out.println(eye.read());
		System.out.println(hand.write());
	}
	
	public void setEye(Eye eye) {
		this.eye = eye;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
}
