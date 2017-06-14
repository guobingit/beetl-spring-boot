package com.gb.design.mode.singleton;

/***
 *
 * ����ģʽҪ��һ�������ҽ���һ��ʵ���������ṩ��һ��ȫ�ֵķ��ʵ�
 *
 * ����ģʽӦ�õĳ���һ�㷢�������������£�
 *��1����Դ���������£�����������Դ����ʱ���µ����ܻ���ĵȡ�����־�ļ���Ӧ�����á�����һЩ��ҪƵ�����������ٵĶ�����ģʽ���ɿ������ϵͳ������
 *��2��������Դ������£�������Դ֮��Ļ���ͨ�š����̳߳صȡ�����ɱ���Ŀ��ʵ��
 *
 * �򵥵ĵ������̲߳���ȫ
 * ������ģʽ(����ʽ)
 * �����Ƚ�����ֻ�е�����getInstance��ʱ�򣬲Ż�ȥ��ʼ���������
 *
 */
public class Singleton1 {
	private static Singleton1 singleton1 = new Singleton1();
	private Singleton1() {}
	public static Singleton1 getInstance() {
		return singleton1;
	}
}
