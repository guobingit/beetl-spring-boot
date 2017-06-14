package com.gb.design.mode.singleton;

/**
 * 线程安全的懒汉单例模式（可以加synchronized,那会耗费很多资源，不建议 ，还可以用双重检查锁,只用于jdk1.5+）
 * 运用静态内部类
 */
public  class Singleton3 {
	
	private static class Holder{
		private static Singleton3 singleton3 = new Singleton3();
	}
	
	public static Singleton3 getInstance(){
		return Holder.singleton3;
	}
}
