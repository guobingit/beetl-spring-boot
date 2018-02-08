 package com.gb.test.service;

import com.gb.module.utils.DigestUtils;
import com.google.common.collect.Maps;
import org.beetl.sql.core.SQLManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static org.apache.coyote.http11.Constants.a;

 /**
 * Created by guobin on 2017/4/10.
 */
@Service
public class BookService {

    @Resource
    private SQLManager sqlManager;
    
     /**
      * 一定要给ssreader表的ss号加索引
      */
    public void bupdate(){

        List lc = sqlManager.execute("select count(*) from ssreader",Integer.class,null);
        for (int i = 0; i < 10; i++) {
            Map<String,Integer> ps = Maps.newHashMap();
            ps.put("top",i*100000);
            System.out.println("第"+i*100000+"条");
            List<Map> books = sqlManager.execute("select * from ssreader limit #top#,100000", Map.class,ps);
            books.forEach(bb->{
                Object ssid = bb.get("SS号");
                String opacUrl = (String)bb.get("opacUrl");
                if (Objects.nonNull(ssid)){
                    String ss = ssid.toString();
                    String url = getopac(ss);
                    Map<String,String> params = Maps.newHashMap();
                    params.put("opacUrl",url);
                    params.put("ssid",ss);
                    sqlManager.executeUpdate("update ssreader set opacUrl = #opacUrl# where ss号 = #ssid#",params);
//                    sqlManager.update("book.update", params);
                }
            });
        }
    }

    private String getopac(String ssid){
        String sign = "opac_tocard_hebgydx";
        String key = "uRN^9IWXmwnTHa!ZwD";
        String url = "http://www.sslibrary.com/openapi/book/opacToCard";
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("ssid", ssid);
        params.put("sign", sign);

        List<String> values = new ArrayList<String>();
        values.add("sign=" + sign);
        values.add("ssid=" + ssid);
        values.add(key);

        String enc = DigestUtils.generateMD5(values.toArray());
        params.put("enc", enc);
        String aaa = url + "?sign=" + sign + "&ssid=" + ssid + "&enc=" + enc;
        return aaa;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        System.out.println(bookService.getopac("11675868"));
        System.out.println(System.currentTimeMillis() - a);

    }
}
