package com.gb.module.utils;

/**
 * Created by guobin on 2017/2/13.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    public static String iso2gb(String s) {
        if (s == null) {
            return "";
        }
        try {
            return new String(s.getBytes("ISO-8859-1"), "GBK").trim();
        } catch (Exception e) {
            return s;
        }
    }
}
