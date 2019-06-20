package com.gb.test;

import java.util.Date;
import com.gb.module.utils.DateUtils;

public class TestAuth {
	
	/**
	 * 通过分类号 拼接分类查询语句
	 *
	 * @param c 分类号
	 * @return
	 */
	private String getSQLByClassifies(String c) {
		String sql = "";
		int len = c.length();
		while (len > 0) {
			String tmp = c.substring(0, 2);
			sql += " or 分类号 like '" + tmp + "%'";
			c = c.substring(2);
			len = c.length();
		}
		sql = " and (" + sql.substring(4) + ")";
		return sql;
	}
	
	public static void main(String[] args) {
		String date = "2018-07-31 14:55:04";
		Date d = DateUtils.strToDate(date, "yyyy-MM-dd HH:mm:ss");
		System.out.println(d.getTime());
	}
}

