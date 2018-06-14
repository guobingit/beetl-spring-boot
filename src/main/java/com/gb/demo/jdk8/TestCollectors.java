package com.gb.demo.jdk8;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;
import com.sh.beetl.entity.User;

/**
 * jdk8�ۼ�collect��ʹ��
 * Created by guobin on 2017/5/4.
 */
public class TestCollectors {

    public static void main(String[] args) {
        List<User> users = Lists.newArrayList(new User(1, 21, "zhangsan", 0), new User(1, 32, "lisi", 1), new User(1, 35, "wangwu", 1), new User(1, 41, "zhaoliu", 1));
        //toList
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
        //toSet
        Set<String> namesset = users.stream().map(User::getName).collect(Collectors.toSet());
        //toTreeSet
        Set<String> namesset1 = users.stream().map(User::getName).collect(Collectors.toCollection(TreeSet::new));
        //joining ','Ϊ����� "AAA"Ϊǰ׺ "BBB"Ϊ��׺ AAAzhangsan,lisi,wangwu,zhaoliuBBB
        //Ϊ��ֱ�Ӻϲ���һ��������������ϣ��������� ǰ��׺
        String jstr = users.stream().map(User::getName).collect(Collectors.joining(",", "AAA", "BBB"));
        System.out.println(jstr);
        //sumingInt ..long..double �ۼ� averagingInt ..long..double ƽ��
        Integer sumage = users.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(sumage);
        //mapping ....
        //eg:....
        //counting == reducing(0L, e -> 1L, Long::sum)
        //reducing
        //groupingBy
        //toMap

    }
}
