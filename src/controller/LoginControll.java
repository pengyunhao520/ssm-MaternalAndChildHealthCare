package controller;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import domain.User;
import service.IUserService;
import shiro.realm.LzRealm;
import util.AjaxResult;
import util.MD5;
import util.MD5Util;
import util.UserContext;


/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
@Controller
public class LoginControll {
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @param verificationCode
	 * @return
	 */
	
	@Autowired
	private IUserService userservice;
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxResult login(String username,String password,String randomCode) {
			
			//1.获取当前登录用户的对象的Subject
			Subject currentUser = SecurityUtils.getSubject();
			//2.判断用户是否已经认证
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			
			HttpSession session = request.getSession();
			
			
			Map<String, String[]> map = request.getParameterMap();
			
			//校验验证码的输入是否正确
			//获取输入的验证码
			String code = map.get("randomCode")[0];
			
			//获取session中存储的验证码
			String string = (String) session.getAttribute("RANDOMCODE_IN_SESSION");
			
			
			
			
			//3.将用户名和密码封装成一个token对象
			UsernamePasswordToken token = new UsernamePasswordToken(username,password,randomCode);
			try{
				System.out.println(string+"="+code);
				if (string.equals(code)) {
					//4.调用Subject对象的login方法进行身份认证
					currentUser.login(token);
					//认证成功
					User user = (User) currentUser.getPrincipal();
					//将信息存入session范围
					Session usercontext = UserContext.setUser(user);
					return new AjaxResult("登录成功");
				 }else {
					 return new AjaxResult("验证码有误",-109);
					 
				 }
			} catch (UnknownAccountException e) {
				//用户名不存在
				e.printStackTrace();
				return new AjaxResult("用户名不存在",-100);
			} catch (IncorrectCredentialsException e1) {
				e1.printStackTrace();
				//密码不正确
				return new AjaxResult("密码错误!",-101);
				
			}catch (LockedAccountException e2){
					e2.printStackTrace();
					return new AjaxResult("账号被锁定!", -102
							);
			}catch (AccountException e3){
				e3.printStackTrace();
				return new AjaxResult("账号异常!", -103);
			}catch (CredentialsException e4){
				e4.printStackTrace();
				return new AjaxResult("凭证异常!", -104);
			}catch (UnsupportedTokenException e5){
				e5.printStackTrace();
				return new AjaxResult("未知的登录令牌异常!", -105);
			}catch (AuthenticationException e6){
				e6.printStackTrace();
				return new AjaxResult("未知的登录异常!", -106);
			}

	}
}

