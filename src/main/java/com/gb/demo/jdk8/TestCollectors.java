package com.gb.demo.jdk8;

import java.util.*;
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
		// 比较两个list相同的
		int size = users.stream()
				.map(t -> users.stream().filter(s -> Objects.nonNull(t.getName()) && Objects.nonNull(s.getName()) && Objects.equals(t.getName(), s.getName())).findAny().orElse(null))
				.filter(Objects::nonNull)
				.collect(Collectors.toList())
				.size();
		List<String> names1 = users.stream()
				.map(t -> users.stream().filter(s -> Objects.nonNull(t.getName()) && Objects.nonNull(s.getName()) && Objects.equals(t.getName(), s.getName())).findAny().orElse(null))
				.filter(Objects::nonNull)
				.map(r -> r.getName())
				.collect(Collectors.toList());
		
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
	public static void compareListHitData(List<Map<Object, Object>> oneList, List<Map<Object, Object>> twoList) {
		List<Map<Object, Object>> resultList = oneList.stream().map(map -> twoList.stream()
				.filter(m -> Objects.equals(m.get("id"), map.get("id")))
				.findFirst().map(m -> {
					map.putAll(m);
					return map;
				}).orElse(null))
				.filter(Objects::nonNull).collect(Collectors.toList());
		
		List<User> users1 = Lists.newArrayList(new User(1, 21, "zhangsan", 0), new User(2, 32, "lisi", 1), new User(3, 35, "wangwu", 1), new User(4, 41, "zhaoliu", 1));
		List<User> users2 = Lists.newArrayList(new User(3, 21, "zhangsan", 0), new User(4, 32, "lisi", 1), new User(5, 35, "wangwu", 1), new User(6, 41, "zhaoliu", 1));
		// 比较两个list 过滤掉重复的
		List<User> noClassList1 = users1.stream().filter(s1 ->users2.stream().noneMatch(s2 -> Objects.equals(s1.getId(), s2.getId()))).collect(Collectors.toList());
	}
	
	/**
	 * 把参数的map 转换成url
	 */
	public static void toUrlKey() {
		Map<String, Object> params = new HashMap<>();
		params.put("fid", 123);
		params.put("roleIds", 1);
		params.put("offset", 0);
		params.put("limit", 500);
		String aa = params.entrySet().stream().map(p-> p.getKey() + "=" + p.getValue()).collect(Collectors.joining("&"));
		System.out.println(aa);
	}
	
}
