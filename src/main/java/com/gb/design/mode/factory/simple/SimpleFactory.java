package com.gb.design.mode.factory.simple;

import org.junit.Test;

/**
 * 简单工厂
 */
public class SimpleFactory {
	
	abstract class BW{
	}
	
	class BWX1 extends BW{
		public BWX1() {
			System.out.println("this is BW X1");
		}
	}
	
	class BWQ5 extends BW{
		public BWQ5(){
			System.out.println("this is BW Q5");
		}
	}
	
	class Factory{
		public BW createBW(int type){
			switch (type){
				case 1:
					return new BWX1();
				case 2:
					return new BWQ5();
				default:
					return null;
			}
		}
	}
	
	@Test
	public  void Test() {
		Factory factory = new Factory();
		factory.createBW(1);
		
	}
}
