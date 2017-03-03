package com.gb.test;

/**
 * Created by guobin on 2017/2/13.
 */
public class TestDemo {

    public static void main(String[] arg){
        String a = "2.33333E8";
        System.out.println(formateDouble(a));

    }

    public static String formateDouble(String d){
        try {
            Double a = new Double(d);
            java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            return nf.format(a);
        }catch (Exception e){
            return d;
        }
    }
}
