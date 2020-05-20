package com.gb.demo.jdk8;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;
import com.sh.beetl.entity.User;

/**
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
		String jstr = users.stream().map(User::getName).collect(Collectors.joining(",", "AAA", "BBB"));
		System.out.println(jstr);
		Integer sumage = users.stream().collect(Collectors.summingInt(User::getAge));
		System.out.println(sumage);
		//mapping ....
		//eg:....
		//counting == reducing(0L, e -> 1L, Long::sum)
		//reducing
		//groupingBy
		//toMap
		
	}
	
	/**
	 * list 转 map
	 */
	public static void listToMap() {
		List<User> users = Lists.newArrayList(new User(1, 21, "zhangsan", 0), new User(1, 32, "lisi", 1), new User(1, 35, "wangwu", 1), new User(1, 41, "zhaoliu", 1));
		// 指定key-value，value是对象中的某个属性值。
		Map<Integer, String> map = users.stream().collect(Collectors.toMap(User::getId, User::getName));
		// 指定key-value，value是对象本身，User->User 是一个返回本身的lambda表达式
		Map<Integer, User> userMap2 = users.stream().collect(Collectors.toMap(User::getId, User -> User));
		// 指定key-value，value是对象本身，Function.identity()是简洁写法，也是返回对象本身
		Map<Integer, User> userMap3 = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
		// 指定key-value，value是对象本身，Function.identity()是简洁写法，也是返回对象本身，key 冲突的解决办法，这里选择newValue覆盖第一个oldValue。
		Map<Integer, User> userMap4 = users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (oldValue, newValue) -> newValue));
		// 转换为TreeMap
		Map<Integer, User> treeMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (oldValue, newValue) -> newValue, TreeMap::new));
		
		
	}
	
	/**
	 * 遍历两个list 取出相同的
	 *
	 * @param oneList
	 * @param twoList
	 * @return
	 */
	public static List<Map<Object, Object>> compareListHitData(List<Map<Object, Object>> oneList, List<Map<Object, Object>> twoList) {
		List<Map<Object, Object>> resultList = oneList.stream().map(map -> twoList.stream()
				.filter(m -> Objects.equals(m.get("id"), map.get("id")))
				.findFirst().map(m -> {
					map.putAll(m);
					return map;
				}).orElse(null))
				.filter(Objects::nonNull).collect(Collectors.toList());
		return resultList;
	}
	
	
}
