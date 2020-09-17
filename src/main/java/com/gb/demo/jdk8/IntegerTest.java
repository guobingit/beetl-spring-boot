package com.gb.demo.jdk8;

public class IntegerTest {
	
	//1、在-128~127的Integer值并且以Integer x = value;的方式赋值的Integer值在进行==和equals比较时，都会返回true，因为Java里面对处在在-128127之间的Integer值，
	// 用的是原生数据类型int，会在内存里供重用，也就是说这之间的Integer值进行==比较时只是进行int原生数据类型的数值比较，而超出-128127的范围，进行==比较时是进行地址及数值比较。
	//2、第三段旨在说明：==和equals的区别，==是进行地址及值比较，无法对==操作符进行重载，而对于equals方法，Integer里面的equals方法重写了Object的equals方法，查看Integer源码可以看出equals方法进行的是数值比较。
	public static void main(String[] args) {
		
		// 两个new出来的Integer类型的数据比较，相当于把new出来的地址作比较
		Integer a0 = new Integer(1);
		Integer a1 = new Integer(1);
		System.out.println("Integer 对象作比较 a0 == a1: " + (a0 == a1));
		
		// 调用intValue方法得到其int值
		System.out.println("使用intValue得到int值作比较 a0 == a1: " + (a0.intValue() == a1.intValue()));
		
		// 把Integer类型的变量拆箱成int类型
		int a2 = 1;
		System.out.println("将Integer自动拆箱 a1 == a2: " + (a1 == a2));
		
		// Integer对象赋值比较，其实也是内存地址的比较
		// 自动装箱，如果在-128到127之间，则值存在常量池中
		Integer a3 = 30;
		Integer a4 = 30;
		System.out.println("Integer对象赋值比较 a3 == a4: " + (a3 == a4));
		
		// Integer对象赋值(超过-128~127区间)比较
		Integer a5 = 128;
		Integer a6 = 128;
		System.out.println("Integer对象赋值(超过-128~127区间)比较 a5 == a6: " + (a5 == a6));
		
		// Integer对象赋值(超过-128~127区间)比较,调用intValue后再作比较
		Integer a7 = 128;
		Integer a8 = 128;
		System.out.println("Integer对象赋值(超过-128~127区间)比较,调用intValue后 a7 == a8: " + (a7.intValue() == a8.intValue()));
		
		// 使用Integer类的equals()方法进行的是数值的比较
		Integer a9 = 129;
		int a10 = 129;
		System.out.println("Integer类的equals()方法进行的是数值的比较 a9 == a10: " + a9.equals(a10));
	}
}
