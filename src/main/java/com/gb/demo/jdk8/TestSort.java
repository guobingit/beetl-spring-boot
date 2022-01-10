package com.gb.demo.jdk8;

import com.google.common.collect.Lists;
import com.sh.beetl.entity.User;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestSort {
    @Test
    public void testSort() {
        List<User> users = Lists.newArrayList(new User(1, 21, "zhangsan", 0), new User(1, 32, "lisi", 1), new User(1, 35, "wangwu", 1), new User(1, 41, "zhaoliu", 1));
        users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
        users.stream().sorted((t1, t2) -> t2.getAge() - t1.getAge()).collect(Collectors.toList());
        users.stream().sorted(Comparator.comparingInt(User::getAge).thenComparing(User::getId).reversed()).collect(Collectors.toList());
        users.stream().sorted(Comparator.comparing(User::getName, Comparator.comparingInt(s -> NumberUtils.toInt(s.substring(s.indexOf("-") + 1)))));
    }
}
