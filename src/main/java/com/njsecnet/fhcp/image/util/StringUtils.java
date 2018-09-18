package com.njsecnet.fhcp.image.util;

/**
 * 
 * 字符串工具集合
 */
public class StringUtils {

	private StringUtils() {
	}

	/**
	 * 检测字符串是否为null，或者trim()以后的长度是否为0。
	 */
	public static boolean isEmpty(String s) {
		if (s == null) {
			return true;
		}
		return s.trim().length() == 0;
	}

}