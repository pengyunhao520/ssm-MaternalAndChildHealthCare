package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.DictionaryDetails;
import domain.PregnantWomanInformation;
import domain.PrenatalReviewRecord;
import query.PrenatalReviewRecordQuery;
import service.IDictionaryDetailsService;
import service.IPregnantWomanInformationService;
import service.IPrenatalReviewRecordService;
import util.AjaxResult;
import util.PageList;

@Controller
@RequestMapping("/PrenatalReviewRecord")
public class PrenatalReviewRecordController {
	
	@Autowired
	private IPrenatalReviewRecordService prrService;
	
	@Autowired
	private IPregnantWomanInformationService pwiService;
	
	@Autowired
	private IDictionaryDetailsService ddService;
	
	/**
	 * 加载人员基本信息
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "PrenatalReviewRecord/index";
	}
	/**
	 * 分页展示人员基本信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public PageList<PrenatalReviewRecord> page(PrenatalReviewRecordQuery query){
		return prrService.getByQuery(query);
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
			prrService.delete(id);
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
	public AjaxResult save(PrenatalReviewRecord prr){
		AjaxResult ar = null;
		try {
			if (prr.getId()==null) {
				List<PrenatalReviewRecord> allByidnumber = prrService.selectAllByidnumber(prr.getPreidnumber());
				if (allByidnumber.size()>0) {
					prr.setReviewcount(allByidnumber.size()+1);
					prrService.add(prr);
				}else {
					//添加
					prr.setReviewcount(1);
					prrService.add(prr);
				}
			} else {
				
				prrService.update(prr);
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
	
	//查询所有的fetalposition
	@RequestMapping("/fetalposition")
	@ResponseBody
	public List<DictionaryDetails> getFetalposition() {
		return ddService.selectByfetalposition();
	}
	
	//查询所有的fetalpresentation
	@RequestMapping("/fetalpresentation")
	@ResponseBody
	public List<DictionaryDetails> getFetalpresentation() {
		return ddService.selectByfetalpresentation();
	}
}
