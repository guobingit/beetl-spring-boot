package com.gb.design.mode.adapter;

import org.junit.Test;

/**
 * 适配器模式
 * 将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
 * Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
 * <p>
 * 类适配器
 */
public class ClassAdapterMode {
	
	class Adaptee {
		public void pread() {
			System.out.println("被适配的类");
		}
	}
	
	interface Target {
		void read();
	}
	
	class ConcreteTarget implements Target {
		
		@Override
		public void read() {
			System.out.println("普通的类");
		}
	}
	
	//重点
	class Adapter extends Adaptee implements Target {
		
		@Override
		public void read() {
			super.pread();
		}
	}
	
	@Test
	public void Test() {
		
		ConcreteTarget concreteTarget = new ConcreteTarget();
		concreteTarget.read();
		
		Target adapter = new Adapter();
		adapter.read();
	}
}
