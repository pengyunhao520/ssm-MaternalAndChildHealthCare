package shiro.factory;

import java.util.LinkedHashMap;
import java.util.Map;

public class FilterChainMapFactory{
	public Map<String, String> getFileterChainMap(){
		Map<String, String> map = new LinkedHashMap<>();
		//定义过滤器
		map.put("/login.jsp", "anon");
		map.put("/login", "anon");
		map.put("/static/**", "anon");
		map.put("/randomCode", "anon");
		//验证码
		map.put("/randomCode", "anon");
		//退出登录
		map.put("/logout", "logout");
		
		//除了匿名的资源外，其他的资源都必须身份认证后才能访问
		//map.put("/**", "authc");
		return map;
	}
}
