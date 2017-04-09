package com.gb.test;

import java.net.URLEncoder;

/**
 * Created by guobin on 2017/2/13.
 */
public class TestDemo {

    public static void main(String[] arg){
        String a = "1\n";
        System.out.println(a.replaceAll("\\r|\\n",""));
        String b = "<a>a123</a>";
        try {
            System.out.println(URLEncoder.encode(b,"utf-8"));
        }catch (Exception e){

        }

    }
}
