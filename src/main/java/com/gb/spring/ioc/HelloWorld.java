package com.gb.spring.ioc;
/**
 *  ioc Inversion of Control
 *  or
 *  DI Dependency Injection
 */
public class HelloWorld {
	interface Language {
		void print();
	}
	
	static class Java implements Language {
		@Override
		public void print() {
			System.out.println("java");
		}
	}
	
	static class Coder {
		private Language lang = new Java();
		
		private void helloWorld() {
			lang.print();
		}
	}
	
	public static void main(String[] args) {
		Coder coder = new Coder();
		coder.helloWorld();
	}
}
