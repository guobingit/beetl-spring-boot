package com.gb.design.mode.facade;

import org.junit.Test;

/**
 * ���ģʽ
 * Ϊ��ϵͳ�е�һ��ӿ��ṩ��һ��ͳһ�ķ��ʽӿڣ�����ӿ�ʹ����ϵͳ�����ױ����ʻ���ʹ��
 * ����˵����ģʽ���ǰ�һЩ���ӵ����̷�װ��һ���ӿڹ����ⲿ�û����򵥵�ʹ�á����ģʽ�У���Ƶ�3����ɫ��
 * ����1��.�����ɫ�����ģʽ�ĺ��ġ������ͻ���ɫ���ã�����Ϥ��ϵͳ�Ĺ��ܡ��ڲ����ݿͻ���ɫ������Ԥ���˼��ֹ��ܵ���ϡ�
 * ����2��.��ϵͳ��ɫ:ʵ������ϵͳ�Ĺ��ܡ����Կͻ���ɫ��Facadeʱδ֪�ġ����ڲ�������ϵͳ�ڵ��໥������Ҳ�����ɹ������õĽӿڡ�
 * ����3��.�ͻ���ɫ:ͨ������Facede�����Ҫʵ�ֵĹ��ܡ�
* ʹ�ó�����
 * ����1- Ϊ���ӵ�ģ�����ϵͳ�ṩ�����ʵ�ģ�飻
 * ����2- ��ϵͳ�໥������
 * ����3- �ڲ����ṹ�У�����ʹ�����ģʽ����ϵͳ��ÿһ�����ڡ�
 */
public class FacadeMode {
	class SubSysOne {
		public void method1() {
			System.out.println("sub one");
		}
	}
	
	class SubSysTwo {
		public void method2() {
			System.out.println("sub two");
		}
	}
	
	class Facade {
		SubSysOne subSysOne;
		SubSysTwo subSysTwo;
		
		//�ص�
		public Facade() {
			this.subSysOne = new SubSysOne();
			this.subSysTwo = new SubSysTwo();
		}
		
		public void method() {
			subSysOne.method1();
			subSysTwo.method2();
		}
	}
	
	@Test
	public void test() {
		Facade facade = new Facade();
		facade.method();
	}
}
