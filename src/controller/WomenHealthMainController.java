package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WomenHealthMainController {
	@RequestMapping("/WomenHealthMain")
	public String index(){
		return "WomenHealthMain";
	}
}
