package com.gb.demo.jdk8;

import java.util.stream.Stream;

public class TestReduce {
	
	public static void main(String[] args) {
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(10, Integer::sum);
		System.out.println("初始值求和=====" +sumValue);
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		System.out.println("无初始值求和=====" + sumValue);
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").
				filter(x -> x.compareTo("Z") > 0).
				reduce("", String::concat);
		System.out.println("字数串连接====" + concat);
	}
}
