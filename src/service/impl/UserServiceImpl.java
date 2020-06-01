package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import mapper.UserMapper;
import service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	@Autowired
	private UserMapper user;
	
	@Override
	public User selectByUsername(String username) {
		return user.selectByUsername(username);
		
	}
	
	
}
