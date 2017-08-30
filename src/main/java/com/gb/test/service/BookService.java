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

    public void bupdate(){

        List lc = sqlManager.execute("select count(*) from ssreader",Integer.class,null);
        for (int i = 0; i < 10; i++) {
            Map<String,Integer> ps = Maps.newHashMap();
            ps.put("top",i*100000);
            System.out.println("第"+i*100000+"条");
            List<Map> books = sqlManager.execute("select * from ssreader limit #top#,100000", Map.class,ps);
            books.forEach(bb->{
                Object isbnObject = bb.get("isbn号");
                if (Objects.nonNull(isbnObject)){
                    String isbn = isbnObject.toString();
                    String url = getopac(isbn);
                    Map<String,String> params = Maps.newHashMap();
                    params.put("ssid",bb.get("SS号").toString());
                    params.put("opacUrl",url);

                    sqlManager.executeUpdate("update ssreader set opacUrl = #opacUrl# where SS号 = #ssid#",params);
                }
            });
        }
    }

    private String getopac(String isbn){
        String sign = "hebsydx_opac_tocard";
        String key = "rDRH6ndlQwx0q9aRyX";
        String url = "http://www.sslibrary.com/openapi/book/opacToCard";
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("isbn", isbn);
        params.put("sign", sign);

        List<String> values = new ArrayList<String>();
        values.add("isbn=" + isbn);
        values.add("sign=" + sign);
        values.add(key);

        String enc = DigestUtils.generateMD5(values.toArray());
        params.put("enc", enc);
        String aaa = url + "?sign=" + sign + "&isbn=" + isbn + "&enc=" + enc;
        return aaa;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        System.out.println(bookService.getopac("123"));
        System.out.println(System.currentTimeMillis() - a);

    }
}
