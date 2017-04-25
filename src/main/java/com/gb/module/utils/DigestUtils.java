/**
 * MD5加密
 */
package com.gb.module.utils;

public class DigestUtils extends org.apache.commons.codec.digest.DigestUtils {
	
	/**
	 * 组合原文，MD5加密
	 * 
	 * @param source
	 * @return
	 */
	public static String generateMD5(Object... source) {
		if (source == null) {
			return null;
		}
		String str = "";
		for (Object o : source) {
			str = str.concat("[" + o.toString() + "]");
		}
		try {
			return md5Hex(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 带编码的md5加密，解决gbk加密的问题
	 * 
	 * @param s
	 * @param string
	 * @return
	 */
	public static String md5Hex(String s, String encode) {
		try {
			return md5Hex(s.getBytes(encode));
		} catch (Exception e) {
			return null;
		}
	}
	
}
