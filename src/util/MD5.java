package util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5 {
	public static void  main(String[] args){
		//加密算法
		String algorithmName="md5";
		//加密的数据
		Object source="55555";
		//盐值项目中可以动态根据登录的用户信息获取
		Object salt="lz";
		//加密次数
		int hashIterations=2000;
		SimpleHash sh = new SimpleHash(algorithmName, source, salt, hashIterations);
		
		System.out.println(sh.toString());
		System.out.println(sh.toString().length()+sh.getAlgorithmName());
		
	}
}
