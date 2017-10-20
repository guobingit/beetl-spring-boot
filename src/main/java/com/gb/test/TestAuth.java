package com.gb.test;

import java.io.UnsupportedEncodingException;

public class TestAuth {

    public static void main(String[] args) {
    
        try {
            System.out.println(new String("IP地址列表.doc".getBytes("GBK"), "iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

