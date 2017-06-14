package com.gb.design.mode.singleton;

/**
 * 饿单例模式
 * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
 *
 */
public class Singleton2 {
	private Singleton2(){}
	private static final Singleton2 SINGLETON_2 = new Singleton2();
	public static Singleton2 getInstance(){
		return SINGLETON_2;
	}
}
