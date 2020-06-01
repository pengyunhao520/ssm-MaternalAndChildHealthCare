package shiro.realm;

import java.security.Principal;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import domain.User;
import service.IUserService;
import util.MD5Util;

public class LzRealm extends AuthorizingRealm{

	@Autowired
	private IUserService userservice;
	
	/**
	 * 身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1获取用户名
		UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		//2.根据用户名查询并返回结果
		User user = userservice.selectByUsername(username);
		
		//3.做初步的判断
		if (user==null) {
			throw new UnknownAccountException("--该用户不存在");
		}
	
		//4.将用户信息封装到info对象中返回给shiro
		Object principal = user;//身份，user对象
		Object hashedCredntials = user.getPassword();//密码，凭证
		ByteSource credentialsSalt = ByteSource.Util.bytes(MD5Util.SALT);//盐值
		String realmName = getName();
		SimpleAuthenticationInfo Info = new SimpleAuthenticationInfo(principal,hashedCredntials,credentialsSalt,realmName);
		
		return Info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

}
