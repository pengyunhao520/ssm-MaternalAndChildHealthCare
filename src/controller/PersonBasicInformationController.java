package controller;

import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import domain.Education;
import domain.GeneticHistory;
import domain.Nation;
import domain.PersonBasicInformation;
import domain.PregnantWomanInformation;
import domain.PrewomanGeneticHistory;
import domain.SysArea;
import domain.SysCity;
import domain.SysProvince;
import domain.SysStreet;
import query.PersonBasicInformationQuery;
import service.IEducationService;
import service.IGeneticHistoryService;
import service.INationService;
import service.IPersonBasicInformationService;
import service.IPregnantWomanInformationService;
import service.IPrewomanGeneticHistoryService;
import service.ISysAreaService;
import service.ISysCityService;
import service.ISysProvinceService;
import service.ISysStreetService;
import util.AjaxResult;
import util.PageList;
import util.ReturnQUtils;

@Controller
@RequestMapping("/PersonBasicInformation")
public class PersonBasicInformationController {
	
	@Autowired
	private IPersonBasicInformationService pbisService;
	
	@Autowired
	private IEducationService educationService;
	
	@Autowired
	private INationService nationService;
	
	@Autowired
	private ISysProvinceService sysProvinceService;
	
	@Autowired
	private ISysCityService sysCityService;
	
	@Autowired
	private ISysAreaService sysAreaService;
	
	@Autowired
	private ISysStreetService sysStreetService;

	@Autowired
	private IGeneticHistoryService geneticHistoryService;
	
	@Autowired
	private IPregnantWomanInformationService pwiService;
	
	@Autowired
	private IPrewomanGeneticHistoryService pwghService;
	
	
	/**
	 * 加载人员基本信息
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "PersonBasicInformation/index";
		
	}
	/**
	 * 分页展示人员基本信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public PageList<PersonBasicInformation> page(PersonBasicInformationQuery query){
		return pbisService.getByQuery(query);
	}
	
	@RequestMapping("/toper")
	@ResponseBody
	public PageList<PersonBasicInformation>toPer(PersonBasicInformationQuery query,String husbandid){
		return pbisService.getByQuery(query);
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
			pbisService.delete(id);
			geneticHistoryService.delete(id);
			ar=new AjaxResult("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("删除失败!"+e.getMessage(),-1001);
		}
		return ar;
	}
	
	//转为普通人员
	@RequestMapping("/pretoper")
	@ResponseBody
	public AjaxResult preToPer(Integer id){
		AjaxResult ar = null;
		try {
			PregnantWomanInformation pwi = pwiService.getOne(id);
			PrewomanGeneticHistory pwgh = pwghService.getOne(id);
			PersonBasicInformation pbi=new PersonBasicInformation();
			GeneticHistory gh=new GeneticHistory();
			pbi.setHealthcode(pwi.getHealthcode());
			pbi.setName(pwi.getName());
			pbi.setSex(pwi.getSex());
			pbi.setAge(pwi.getAge());
			pbi.setBirthdate(pwi.getBirthdate());
			pbi.setNation(pwi.getNation());
			pbi.setEducation(pwi.getEducation());
			pbi.setProfession(pwi.getProfession());
			pbi.setProvince(pwi.getProvince());
			pbi.setCity(pwi.getCity());
			pbi.setCounty(pwi.getCounty());
			pbi.setTown(pwi.getTown());
			pbi.setGardon(pwi.getGardon());
			pbi.setWorkunit(pwi.getWorkunit());
			pbi.setPhonenumber(pwi.getPhonenumber());
			pbi.setWechat(pwi.getWechat());
			pbi.setIdNumber(pwi.getIdnumber());
			pbi.setIsLocal(pwi.getIslocal());
			pbi.setBirthcertificatenumber(pwi.getBirthcertificatenumber());
			pbi.setRestaddress(pwi.getRestaddress());
			pbi.setIsPregnantwoman(pwi.getIspregnantwoman());
			pbi.setMarryhistory(pwi.getMarryhistory());
			pbisService.add(pbi);
			gh.setId(pbi.getId());
			gh.setPsychosis(pwgh.getPsychosis());
			gh.setPsychosisdescribe(pwgh.getPsychosisdescribe());
			gh.setDementia(pwgh.getDementia());
			gh.setDementiadescribe(pwgh.getDementiadescribe());
			gh.setGeneticdisease(pwgh.getGeneticdisease());
			gh.setGeneticdiseasedescribe(pwgh.getGeneticdiseasedescribe());
			gh.setMalformation(pwgh.getMalformation());
			gh.setMalformationdescribe(pwgh.getMalformationdescribe());
			geneticHistoryService.add(gh);
			pwiService.delete(id);
			pwghService.delete(id);
			ar=new AjaxResult("转换成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("转换失败!"+e.getMessage(),-1001);
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
	public AjaxResult save(PersonBasicInformation pbis,GeneticHistory geneticHistory){
		AjaxResult ar = null;
		try {
			if (pbis.getId()==null) {
				//添加
				pbisService.add(pbis);
				geneticHistory.setId(pbis.getId());
				geneticHistoryService.add(geneticHistory);
			} else {
				PersonBasicInformation perone = pbisService.getOne(pbis.getId());
				//获取pre中husbandid关联了perid的数据，进行更新
				List<PregnantWomanInformation> allByhusbandid = pwiService.selectAllByhusbandid(pbis.getId());
				//判断当前是否有修改idnumber，没有则进入if
				//有怎进入else进行修改操作
				if (pbis.getIdNumber().equals(perone.getIdNumber()) && allByhusbandid.size()>0) {
					//如果用户修改了per中的age，name，phonenumber，则pre中的值也相应进行更改
					pbisService.update(pbis);
					geneticHistoryService.update(geneticHistory);
					for (PregnantWomanInformation p : allByhusbandid) {
						p.setHusbandage(pbis.getAge());
						p.setHusbandname(pbis.getName());
						p.setHusbandphonenumber(pbis.getPhonenumber());
						pwiService.update(p);
					}
				}else {
					pbisService.update(pbis);
					geneticHistoryService.update(geneticHistory);
				}
				
			}
			ar=new AjaxResult("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("保存失败!"+e.getMessage(), -1002);
		}
		return ar;
	}
	
	@RequestMapping("/education")
	@ResponseBody
	public List<Education> getEducation(){
		return educationService.getAll();
	}
	
	@RequestMapping("/nation")
	@ResponseBody
	public List<Nation> getNation(){
		return nationService.getAll();
	}
	
	@RequestMapping("/province")
	@ResponseBody
	public List<SysProvince> getProvince(){
		return sysProvinceService.getAll();
	}
	
	@RequestMapping("/city")
	@ResponseBody
	public List<SysCity> getCity(String provinceid){
		return sysCityService.selectByProvinceID(provinceid);
	}
	
	@RequestMapping("/area")
	@ResponseBody
	public List<SysArea> getArea(String cityid){
		return sysAreaService.selectByCityID(cityid);
	}
	
	@RequestMapping("/street")
	@ResponseBody
	public List<SysStreet> getStreet(String countyid){
		return sysStreetService.selectBycountyID(countyid);
	}
}
