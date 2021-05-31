package com.gb.demo.Algorithm.bitset;

import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * BetSet测试方法
 */
public class BitSetTest {
	
	/**
	 * 阿里的实习面试题
	 * 有1千个随机数，随机数的范围在1到1万之间。
	 * 现在要求写出一种算法，将1到1万之间没有在随机数中的数求出来
	 */
	@Test
	public void random() {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			int randomInt = random.nextInt(10000);
			list.add(randomInt);
		}
		BitSet bitSet = new BitSet(10000);
		for (int i = 0; i < 1000; i++) {
			bitSet.set(list.get(i));
		}
		for (int i = 0; i < 10000; i++) {
			if (!bitSet.get(i)) {
				System.out.print(i);
				System.out.print(",");
			}
		}
	}
}
