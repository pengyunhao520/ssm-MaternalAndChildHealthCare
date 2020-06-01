package controller;


import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExitBrowser {
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("/exitBrowser")
	public static void main(String[] args) throws IOException {
		 Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM safari.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM opera.exe");
	}
}
