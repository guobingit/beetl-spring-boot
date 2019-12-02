package com.gb.demo.Algorithm.light;

public class CharacterTest {
	
	public static void main(String[] args) {
		//character判断中中文也算作letter（字母）
		System.out.println(Character.isLetterOrDigit('中'));
		System.out.println(Character.isLetter('￥'));
	}
}
