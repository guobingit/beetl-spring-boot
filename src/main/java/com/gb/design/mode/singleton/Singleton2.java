package com.gb.design.mode.singleton;

/**
 * ������ģʽ
 * ����ʽ���ഴ����ͬʱ���Ѿ�������һ����̬�Ķ���ϵͳʹ�ã��Ժ��ٸı䣬�����������̰߳�ȫ�ġ�
 *
 */
public class Singleton2 {
	private Singleton2(){}
	private static final Singleton2 SINGLETON_2 = new Singleton2();
	public static Singleton2 getInstance(){
		return SINGLETON_2;
	}
}
