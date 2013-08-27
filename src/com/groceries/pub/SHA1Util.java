package com.groceries.pub;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SHA1Util {
	protected static MessageDigest messagedigest = null;
	private static Logger log = LogManager.getLogger("SHA1Util");
	
	static
	{
		try {
			messagedigest = MessageDigest.getInstance("sha1");
		} catch(Exception e) {
			log.error("SHA1信息摘要初始化失败：" + e.getMessage());
		}
	}
	
	public static String Encrypt(String content) {
		String mi = "";
		messagedigest.update(content.getBytes());
		mi = new BigInteger(1, messagedigest.digest()).toString(16);
		return mi;
	}
}
