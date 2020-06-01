package controller;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;
import query.UserQuery;
import service.IUserService;
import util.PageList;

@Controller
@RequestMapping("/user")
public class UserController {

/*	@Autowired
	private IUserService userService;
	
	*//**
	 * 
	 * @return
	 *//*
	@RequestMapping("/index")
	public String user() {
		System.out.println("");
		return "user/index";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public PageList<User> page(UserQuery query){
		return userService.getByQuery(query);
	}*/
	
}
