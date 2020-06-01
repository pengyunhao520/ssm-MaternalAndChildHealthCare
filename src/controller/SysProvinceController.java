package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Nation;
import domain.SysProvince;
import service.ISysProvinceService;

@Controller
@RequestMapping("/sysprovince")
public class SysProvinceController {
	
	@Autowired
	private ISysProvinceService sysProvinceService;

	@RequestMapping("/province")
	@ResponseBody
	public List<SysProvince> getNation(){
		return sysProvinceService.getAll();
	}
}
