package com.gb.design.mode.singleton;

/***
 *
 * 单例模式要求一个类有且仅有一个实例，并且提供了一个全局的访问点
 *
 * 单例模式应用的场景一般发现在以下条件下：
 *（1）资源共享的情况下，避免由于资源操作时导致的性能或损耗等。如日志文件，应用配置。对于一些需要频繁创建和销毁的对象单例模式无疑可以提高系统的性能
 *（2）控制资源的情况下，方便资源之间的互相通信。如线程池等。允许可变数目的实例
 *
 * 简单的单例，线程不安全
 * 懒单例模式(懒汉式)
 * 懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例
 *
 */
public class Singleton1 {
	private static Singleton1 singleton1 = new Singleton1();
	private Singleton1() {}
	public static Singleton1 getInstance() {
		return singleton1;
	}
}
