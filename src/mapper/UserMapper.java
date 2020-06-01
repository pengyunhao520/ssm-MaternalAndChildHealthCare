package mapper;

import domain.User;

import java.io.Serializable;
import java.util.List;

public interface UserMapper extends BaseMapper<User>{
	
	List<User> selectByUserId(Long userId);
	
	/**
	 * 根据用户名查询并返回用户信息
	 */
	public User selectByUsername(String username);
	
}