package com.baibutao.hui.common;

import java.security.MessageDigest;

import wint.lang.utils.StringUtil;

public class DigestUtil {

	/**
	 * 
	 * @param str
	 *            待加密
	 * @param compareStr
	 *            待比较
	 * @return
	 */
	public static boolean isSameBySHA1(String str, String compareStr) {
		if (StringUtil.isBlank(str) || StringUtil.isBlank(compareStr)) {
			return false;
		}
		byte[] sha1 = sha1(str);
		return byteArrayToHexString(sha1).equalsIgnoreCase(compareStr);
	}

	public static byte[] sha1(String str) {
		try {
			MessageDigest alga = MessageDigest.getInstance("SHA-1");
			alga.update(str.getBytes());
			return alga.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String signature = "c8dbb02b8d2452a7c9cb480c0bbcb49f5bb64553";
		String key = getKey("1353573512", "1352753680", "fq3fslfwaesfj2");
		System.out.println(isSameBySHA1(key, signature));
		byte[] sha1 = sha1(key);
		System.out.println(byteArrayToHexString(sha1).equalsIgnoreCase(signature));
		System.out.println(signature);
	}
	
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	
	private static String getKey(String s1, String s2, String s3) {
		String min = s1;
		String max = s2;
		int flag1 = min.compareTo(s2);
		if(flag1 > 0) {
			min = s2;
			max = s1;
		}
		
		//  s3<= min < max  
		if(s3.compareTo(min) <= 0) {
			return s3 + min + max;
		}
		
		// min< s3 <= max
		if(s3.compareTo(max) <= 0) {
			return min + s3 + max;
		}
		
		// min < max < s3
		return min + max + s3;
	}

}
