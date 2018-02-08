package com.gb.test;

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
		String c ="";
		System.out.println(c.matches("([0][A-Z])+"));
	}
}

