package com.gb.demo.thread;

/**
 * 多线程永远以实现Runnable接口为主
 * 好处：避免点继承的局限，一个类可以继承多个接口；适合于资源的共享
 * Created by guobin on 2017/3/2.
 */
public class MyTestRunnable implements Runnable {
	
	private String name;
	
	public MyTestRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "*****" + name);
		}
	}
	
	public static void main(String[] args) {
		new Thread(new MyTestRunnable("线程1")).start();
		new Thread(new MyTestRunnable("线程2")).start();
	}
}
