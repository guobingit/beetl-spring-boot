package com.gb.test;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.gb.demo.jdk8.TestCollectors;

/**
 * Created by guobin on 2017/2/13.
 */
public class TestDemo {
    
    public static void traversal(Map<String, String> map) throws Exception{
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, String> itEntry = it.next();
            String itKey = itEntry.getKey();
            String itValue = itEntry.getValue();
            //;
            //ע�⣺����ʹ�����ֱ�����ʽ����ɾ��Ԫ�غ��޸�Ԫ��
            itEntry.setValue(URLEncoder.encode(itValue,"utf-8"));
            //it.remove();
        }
    }
    public static void main(String[] args) throws Exception {
//        Map<String, String> map = new HashMap();
//        map.put("aaa", "aaa");
//        map.put("bbb", "��ʷ");
//        map.put("ccc", "ccc");
//        traversal(map);
    
        TestCollectors.toUrlKey();
        
    }
}
