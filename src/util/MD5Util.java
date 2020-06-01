package util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
	
	//加密的盐值
	public static final String SALT = "lz";
	//密码的加密次数
	public static final int HASHITERATIONS = 2000;
	
	/**
	 * 加密
	 * @param source
	 * @return
	 */
	public static String encrypt(String source){
		SimpleHash sh = new SimpleHash("MD5", source, MD5Util.SALT, MD5Util.HASHITERATIONS);
		return sh.toString();
	}

}
