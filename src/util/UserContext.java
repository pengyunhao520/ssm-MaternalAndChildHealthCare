package util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


import domain.User;

/**
 * 
 * 用户上下文的工具
 * 
 * 支持将用户对象存入到session中 支持从session中取出用户对象
 * 
 * @author Administrator
 *
 */
public class UserContext {
	
	private static final String LOGINUSER = "loginUser";
	

	/**
	 * 将用户对象存入到session中
	 * 
	 * @param emp
	 * @return 
	 */
	public static  Session setUser(User user) {
		// shiro的四大核心功能 -- 会话管理
		// 在web项目中，shiro的会话就是HttpSession
		// 直接向shiro的会话中存取值
		// 获取当前对象
		Subject currentUser = SecurityUtils.getSubject();
		// 获取会话对象
		Session session = currentUser.getSession();
		// 向session中存入值
		session.setAttribute(LOGINUSER, user);
		return session;
	}

	/**
	 * 获取当前登录的用户
	 * @return
	 */
	public static User getUser() {
		// 获取当前对象
		Subject currentUser = SecurityUtils.getSubject();
		// 获取会话对象
		Session session = currentUser.getSession();
		// 获取存入的employee对象
		User user = (User) session.getAttribute(LOGINUSER);
		return user;
	}

}
