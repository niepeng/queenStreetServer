package com.baibutao.hui.biz.util;

import java.security.MessageDigest;

import com.zjuh.sweet.codec.MD5;

public class Md5Util extends MD5 {

	private final static int HMAC_BLKL = 64;
	private final static int HMAC_MD5L = 16;
	private final static byte IPAD = 0x36;
	private final static byte OPAD = 0x5C;

	public static String HMAC(String originData, String key)  {
		try {
			byte[] keyBytes = key.getBytes();
			byte[] orgBytes = originData.getBytes();
			byte[] iBytes = new byte[HMAC_BLKL];
			int conLength2 = HMAC_BLKL + HMAC_MD5L;
			byte[] oBytes = new byte[conLength2];
			int keyLength = keyBytes.length;
			int orgLength = orgBytes.length;
			int conLength = HMAC_BLKL + orgLength;
			byte[] conBytes = new byte[conLength];
			for (int i = 0; i < HMAC_BLKL; i++) {
				if (i < keyLength) {
					iBytes[i] = (byte) (keyBytes[i] ^ IPAD);
					oBytes[i] = (byte) (keyBytes[i] ^ OPAD);
				} else {
					iBytes[i] = IPAD;
					oBytes[i] = OPAD;
				}
				conBytes[i] = iBytes[i];
			}
			for (int i = HMAC_BLKL; i < conLength; i++) {
				conBytes[i] = orgBytes[i - HMAC_BLKL];
			}
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] res1 = md.digest(conBytes);
			for (int i = HMAC_BLKL; i < conLength2; i++) {
				oBytes[i] = res1[i - HMAC_BLKL];
			}
			byte[] res = md.digest(oBytes);
			return byteArrayToHexString(res);
		} catch (Exception e) {
			return "";
		}
		
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

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

}
