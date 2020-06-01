package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.IUserService;

@Controller
public class MainController {
		/**
		 * 主界面
		 * @return
		 */
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/main")
	public String index(){
		return "main";
	}

//	@RequestMapping("/page")
//	@ResponseBody
//	public PageList<User> page(UserQuery query){
//		return userService.getByQuery(query);
//	}
}
