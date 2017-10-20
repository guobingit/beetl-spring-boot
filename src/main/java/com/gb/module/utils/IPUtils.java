package com.gb.module.utils;

/**
 * @author simone (wangxinsh55@126.com)
 */
public class IPUtils {
	
	/**
	 * 将IP转换成长整形数字
	 * 
	 * @param ip
	 * @return
	 */
	public static long toLong(String ip) {
		if (StringUtils.isBlank(ip)) {
			return 0;
		}
		
		String[] sIpArr = ip.trim().split("\\.+");
		if (sIpArr.length != 4) {
			return 0;
		}
		return 16777216 * Long.parseLong(sIpArr[0]) + 65536 * Long.parseLong(sIpArr[1]) + 256 * Long.parseLong(sIpArr[2]) + Long.parseLong(sIpArr[3]);
	}
	
	public static long computeIp(String sIp) {
		long iIp = 0;
		String[] sIpArr = sIp.trim().split("\\.");
		int iCount = sIpArr.length;
		for (int i = 0; i < iCount; i++) {
			try {
				iIp += Long.parseLong(sIpArr[i]) * (long) Math.pow(256, 4 - i);
			} catch (Exception ex) {
				iIp = 0;
			}
		}
		return iIp;
	}
	
	public static void main(String[] args) {
		System.out.println(toLong("127.0.0.1"));
		System.out.println(computeIp("127.0.0.1"));
	}
}
