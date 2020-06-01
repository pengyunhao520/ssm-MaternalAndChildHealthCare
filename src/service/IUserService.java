package service;

import domain.User;

public interface IUserService extends IBaseService<User>{
	/**
	 * 根据用户名查询并返回用户信息
	 */
	public User selectByUsername(String username);
}
