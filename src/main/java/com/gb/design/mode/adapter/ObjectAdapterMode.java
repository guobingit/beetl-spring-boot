package com.gb.design.mode.adapter;

import org.junit.Test;

/**
 * 适配器模式
 * 将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
 * Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
 * <p>
 * 对象适配器
 */
public class ObjectAdapterMode {
	
	interface Target{
		public void read();
	}
	
	class ConcreteTarget implements Target {
		
		@Override
		public void read() {
			System.out.println("普通的类");
		}
	}
	
	class Adaptee {
		public void pread(){
			System.out.println("特殊的类");
		}
	}
	
	class Adapter implements Target{
		
		private Adaptee adaptee;
		//重点
		public Adapter(Adaptee adaptee) {
			this.adaptee = adaptee;
		}
		
		@Override
		public void read() {
			adaptee.pread();
		}
	}
	
	@Test
	public void test(){
		ConcreteTarget concreteTarget = new ConcreteTarget();
		concreteTarget.read();
		
		Target adapter = new Adapter(new Adaptee());
		adapter.read();
	}
}
