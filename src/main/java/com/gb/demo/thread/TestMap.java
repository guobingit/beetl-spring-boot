package com.gb.demo.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guobin on 2017/3/15.
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        for (Map.Entry<String,String> entry :map.entrySet()){
            System.out.println("key="+entry.getKey()+",value="+entry.getValue());
        }

        for(String key : map.keySet()){
            System.out.println("key = " + key);
        }

        for (String value : map.values()){
            System.out.println("value = " + value);
        }
    }
}
