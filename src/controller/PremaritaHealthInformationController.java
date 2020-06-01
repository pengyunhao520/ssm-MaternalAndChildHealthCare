package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.PregnantWomanInformation;
import domain.PremaritaHealthInformation;
import query.PremaritaHealthInformationQuery;
import service.IPregnantWomanInformationService;
import service.IPremaritaHealthInformationService;
import util.AjaxResult;
import util.PageList;

@Controller
@RequestMapping("/PremaritaHealthInformation")
public class PremaritaHealthInformationController {
	
	@Autowired
	private IPremaritaHealthInformationService phiService;
	
	@Autowired
	private IPregnantWomanInformationService pwiService;
	
	
	/**
	 * 加载人员基本信息
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "PremaritaHealthInformation/index";
	}
	/**
	 * 分页展示人员基本信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public PageList<PremaritaHealthInformation> page(PremaritaHealthInformationQuery query){
		return phiService.getByQuery(query);
	}
	
	
	/**
	 * 删除人员基本信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Integer id){
		AjaxResult ar = null;
		try {
			phiService.delete(id);
			ar=new AjaxResult("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("删除失败!"+e.getMessage(),-1001);
		}
		return ar;
	}


	/**
	 * 添加和修改，保存人员基本信息
	 * @param pbisService
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(PremaritaHealthInformation phi){
		AjaxResult ar = null;
		try {
			if (phi.getId()==null) {
				//添加
				phiService.add(phi);
			} else {
				
				phiService.update(phi);
			}
			ar=new AjaxResult("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("保存失败!"+e.getMessage(), -1002);
		}
		return ar;
	}
	
	/**
	 * 查询孕妇的id
	 * @return
	 */
	@RequestMapping("/idnumber")
	@ResponseBody
	public List<PregnantWomanInformation> getIDnumber(){
		return pwiService.selectPreWomanidnumber();
	}
}
