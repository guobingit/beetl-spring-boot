package com.gb.test;

import org.joda.time.DateTime;

/**
 * Created by guobin on 2017/3/24.
 */
public class TestWeek {
    public static void main(String[] args) {
    
        System.out.println(DateTime.now().minusWeeks(1).toString("yyyy-MM-dd"));

    }
}
