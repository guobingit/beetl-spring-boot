package com.gb.demo.Algorithm.bitset;

import org.junit.Test;

import java.util.BitSet;

/**
 * BitSet从下标0开始
 * 设置值：bitSet.set(iPos); 位置从0开始算
 *
 *
 */
public class BitSetMethod {
    
    @Test
    public void set() {
        BitSet bitSet = new BitSet();
        bitSet.set(0,1);
        System.out.println(bitSet.get(0));
    
        BitSet bitSet1 = new BitSet();
        bitSet1.set(1, 2, true);
        System.out.println(bitSet1.get(0));
    }
    
    /**
     * 用于在此BitSet与给定的BitSet(bs)之间执行逻辑或。 当此BitSet位保持值为true(***或***)给定的位集合(BS)对应位持有true值此BitSet被更新。
     */
    @Test
    public void or() {
        // create 2 bitsets
        BitSet bitset1 = new BitSet();
        BitSet bitset2 = new BitSet();
        
        // assign values to bitset1
        bitset1.set(0);
        bitset1.set(1);
        bitset1.set(2);
        bitset1.set(3);
        bitset1.set(4);
        bitset1.set(5);
    
        // assign values to bitset2
        bitset2.set(2);
        bitset2.set(4);
        bitset2.set(6);
        bitset2.set(8);
        bitset2.set(10);
    
        // print the sets
        System.out.println("Bitset1:" + bitset1);
        System.out.println("Bitset2:" + bitset2);
    
        // perform a logical or between the two bitsets
        bitset1.or(bitset2);
        System.out.println("" + bitset1);
    }
    
    /**
     * 返回BitSet的true的个数
     */
    @Test
    public void cardinality() {
        BitSet bitset1 = new BitSet();
        bitset1.set(5);
        bitset1.set(3);
        System.out.println(bitset1.cardinality());
    }
    
    /**
     * 用于返回此Bitset中所有未在给定Bitset中设置相应位的位。
     */
    @Test
    public void andNot() {
        // create an object of two BitSet
        BitSet bs1 = new BitSet(10);
        BitSet bs2 = new BitSet(10);
    
        // By using set() method is to set
        // the values in BitSet 1
        bs1.set(10);
        bs1.set(20);
        bs1.set(30);
        bs1.set(40);
        bs1.set(50);
    
        // By using set() method is to set
        // the values in BitSet 2
        bs2.set(60);
        bs2.set(70);
        bs2.set(50);
        bs2.set(40);
        bs2.set(30);
    
        // Display Bitset1 and BitSet2
        System.out.println("bs1 :" + bs1);
        System.out.println("bs2:" + bs2);
    
        // By using andNot(BitSet) method is to returns
        // all the bits that does not match the bits of given
        // BitSet
    
        bs1.andNot(bs2);
    
        // Display BitSet 1
        System.out.println("bs1.andNot(bs2) : " + bs1);
    
    }
    
    /**
     * 求一个字符串包含的char
     *
     */
    public static void containChars(String str) {
        BitSet used = new BitSet();
        for (int i = 0; i < str.length(); i++)
            used.set(str.charAt(i)); // set bit for char
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = used.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (used.get(i)) {
                sb.append((char) i);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        BitSetMethod.containChars("12311cvsfsfsfsfsfsf");
    
        BitSet bitSet = new BitSet();
        bitSet.set(0,1);
        System.out.println(bitSet.get(0));
        
        
    }
}
