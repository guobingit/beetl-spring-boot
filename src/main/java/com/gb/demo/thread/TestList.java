package com.gb.demo.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by guobin on 2017/3/15.
 */
public class TestList {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        for (Iterator i = strs.iterator(); i.hasNext(); ) {
            System.out.println((String) i.next());
        }

        Iterator i = strs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
