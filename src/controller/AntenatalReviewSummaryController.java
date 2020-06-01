package controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.DictionaryDetails;
import domain.PregnantWomanInformation;
import domain.AntenatalReviewSummary;
import domain.AntenatalReviewSummaryParturient;
import query.AntenatalReviewSummaryQuery;
import service.IDictionaryDetailsService;
import service.IPregnantWomanInformationService;
import service.IAntenatalReviewSummaryParturientService;
import service.IAntenatalReviewSummaryService;
import util.AjaxResult;
import util.PageList;

@Controller
@RequestMapping("/AntenatalReviewSummary")
public class AntenatalReviewSummaryController {
	
	@Autowired
	private IAntenatalReviewSummaryService arsService;
	
	@Autowired
	private IPregnantWomanInformationService pwiService;
	
	@Autowired
	private IDictionaryDetailsService ddService;
	
	@Autowired
	private IAntenatalReviewSummaryParturientService arspService;
	/**
	 * 加载人员基本信息
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "AntenatalReviewSummary/index";
	}
	/**
	 * 分页展示人员基本信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public PageList<AntenatalReviewSummary> page(AntenatalReviewSummaryQuery query){
		return arsService.getByQuery(query);
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
			arsService.delete(id);
			arspService.delete(id);
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
	public AjaxResult save(AntenatalReviewSummary ars,AntenatalReviewSummaryParturient arsp){
		System.out.println(ars);
		System.out.println(arsp);
		AjaxResult ar = null;
		try {
			if (ars.getId()==null) {
				arsp.setId(ars.getId());
				arsService.add(ars);
				arspService.add(arsp);
			} else {
				arsService.update(ars);
				arspService.update(arsp);
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
	@RequestMapping("/dictionarydetails")
	@ResponseBody
	public List<DictionaryDetails> getFetalposition(Integer type) {
		List<DictionaryDetails> list= new ArrayList<>();
		List<DictionaryDetails> all = ddService.getAll();
		for (DictionaryDetails dd : all) {
			if (dd.getTypeid().equals(type)) {
				list.add(dd);
			}
		}
		return list;
	}
}
