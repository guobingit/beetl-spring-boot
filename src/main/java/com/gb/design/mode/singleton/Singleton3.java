package com.gb.design.mode.singleton;

/**
 * �̰߳�ȫ����������ģʽ�����Լ�synchronized,�ǻ�ķѺܶ���Դ�������� ����������˫�ؼ����,ֻ����jdk1.5+��
 * ���þ�̬�ڲ���
 */
public  class Singleton3 {
	
	private static class Holder{
		private static Singleton3 singleton3 = new Singleton3();
	}
	
	public static Singleton3 getInstance(){
		return Holder.singleton3;
	}
}
