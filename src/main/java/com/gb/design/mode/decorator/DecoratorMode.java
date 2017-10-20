package com.gb.design.mode.decorator;

import org.junit.Test;

/**
 * 装饰者模式
 * 装饰者与被装饰者拥有共同的超类，继承的目的是继承类型，而不是行为
 * 实际上Java 的I/O API就是使用Decorator实现的
 */
public class DecoratorMode {
	public interface Component {
		void operation();
	}
	
	public class ConcreteComponent implements Component {
		@Override
		public void operation() {
			System.out.println("具体的操作实现");
		}
	}
	
	public abstract class Decorator implements Component {
		
		private Component component;
		
		public void setComponent(Component component) {
			this.component = component;
		}
		
		@Override
		public void operation() {
			//精髓
			component.operation();
		}
	}
	
	public class ConcreteDecoratorA extends Decorator {
		
		@Override
		public void operation() {
			super.operation();
			methodA();
			System.out.println("具体的装饰类A");
		}
		
		private void methodA() {
			System.out.println("具体的装饰a");
		}
	}
	
	public class ConcreteDecoratorB extends Decorator {
		@Override
		public void operation() {
			super.operation();
			System.out.println("**********");
			System.out.println("具体的装饰类B");
		}
	}
	
	@Test
	public void test() {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA da = new ConcreteDecoratorA();
		ConcreteDecoratorB db = new ConcreteDecoratorB();
		
		da.setComponent(c);
		db.setComponent(da);
		db.operation();
		
	}
}
