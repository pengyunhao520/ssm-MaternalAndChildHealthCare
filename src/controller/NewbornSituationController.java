package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.NewbornSituation;
import query.NewbornSituationQuery;
import service.INewbornSituationService;
import util.AjaxResult;
import util.PageList;

@Controller
@RequestMapping("NewbornSituation")
public class NewbornSituationController {
	
	@Autowired
	private INewbornSituationService newbornSituation;
	
	/**
	 * 加载人员基本信息
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "NewbornSituation/index";
	}
	/**
	 * 分页展示人员基本信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public PageList<NewbornSituation> page(NewbornSituationQuery query){
		return newbornSituation.getByQuery(query);
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
			newbornSituation.delete(id);
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
	public AjaxResult save(NewbornSituation ns){
		AjaxResult ar = null;
		try {
			if (ns.getId()==null) {
				//添加
				newbornSituation.add(ns);
			} else {
				
				newbornSituation.update(ns);
			}
			ar=new AjaxResult("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("保存失败!"+e.getMessage(), -1002);
		}
		return ar;
	}
}
