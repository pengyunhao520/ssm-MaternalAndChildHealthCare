package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Education;
import domain.GeneticHistory;
import domain.Nation;
import domain.PersonBasicInformation;
import domain.PregnantWomanInformation;
import domain.PremaritaHealthInformation;
import domain.PrenatalReviewRecord;
import domain.PrewomanGeneticHistory;
import domain.SysArea;
import domain.SysCity;
import domain.SysProvince;
import domain.SysStreet;
import domain.AbnormalMaternalHistory;
import domain.AntenatalInitialInspection;
import query.PersonBasicInformationQuery;
import query.PregnantWomanInformationQuery;
import service.IAbnormalMaternalHistoryService;
import service.IAntenatalInitialInspectionService;
import service.IEducationService;
import service.IGeneticHistoryService;
import service.INationService;
import service.IPersonBasicInformationService;
import service.IPregnantWomanInformationService;
import service.IPremaritaHealthInformationService;
import service.IPrenatalReviewRecordService;
import service.IPrewomanGeneticHistoryService;
import service.ISysAreaService;
import service.ISysCityService;
import service.ISysProvinceService;
import service.ISysStreetService;
import util.AjaxResult;
import util.NowTimeUtil;
import util.PageList;

@Controller
@RequestMapping("/PregnantWomanInformation")
public class PregnantWomanInformationController {
	@Autowired
	private IPregnantWomanInformationService pwiService;
	
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
	private IPrewomanGeneticHistoryService prewomanGeneticHistoryService;
	
	@Autowired
	private IPersonBasicInformationService pbisService;
	
	@Autowired
	private IGeneticHistoryService ghService;
	
	@Autowired
	private IAbnormalMaternalHistoryService amhService;
	
	@Autowired
	private IPremaritaHealthInformationService phiService;
	
	@Autowired
	private IAntenatalInitialInspectionService AiiService;
	
	@Autowired
	private IPrenatalReviewRecordService prrService;
	
	/**
	 * 加载人员基本信息
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "PregnantWomanInformation/index";
		
	}
	/**
	 * 分页展示人员基本信息
	 * @param query
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public PageList<PregnantWomanInformation> page(PregnantWomanInformationQuery query){
		return pwiService.getByQuery(query);
	}
	
	@RequestMapping("/toper")
	@ResponseBody
	public PageList<PregnantWomanInformation>toPer(PregnantWomanInformationQuery query,String q){
		System.out.println(q);
		query.setQ(q);
		return pwiService.getByQuery(query);
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
			pwiService.delete(id);
			prewomanGeneticHistoryService.delete(id);
			amhService.delete(id);
			ar=new AjaxResult("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("删除失败!"+e.getMessage(),-1001);
		}
		return ar;
	}
	
	
	
	
	//转为孕妇
	@RequestMapping("/pretoper")
	@ResponseBody
	public AjaxResult preToPer(Integer id){
		AjaxResult ar = null;
		try {
			PersonBasicInformation pbi = pbisService.getOne(id);
			GeneticHistory gh = ghService.getOne(id);
			PrewomanGeneticHistory pwgh= new PrewomanGeneticHistory();
			PregnantWomanInformation pwi=new PregnantWomanInformation();
			pwi.setHealthcode((pbi.getHealthcode()));
			pwi.setName(pbi.getName());
			pwi.setSex(pbi.getSex());
			pwi.setAge(pbi.getAge());
			pwi.setBirthdate(pbi.getBirthdate());
			pwi.setNation(pbi.getNation());
			pwi.setEducation(pbi.getEducation());
			pwi.setProfession(pbi.getProfession());
			pwi.setProvince(pbi.getProvince());
			pwi.setCity(pbi.getCity());
			pwi.setCounty(pbi.getCounty());
			pwi.setTown(pbi.getTown());
			pwi.setGardon(pbi.getGardon());
			pwi.setWorkunit(pbi.getWorkunit());
			pwi.setPhonenumber(pbi.getPhonenumber());
			pwi.setWechat(pbi.getWechat());
			pwi.setIdnumber(pbi.getIdNumber());
			pwi.setIslocal(pbi.getIsLocal());
			pwi.setBirthcertificatenumber(pbi.getBirthcertificatenumber());
			pwi.setRestaddress(pbi.getRestaddress());
			pwi.setIspregnantwoman(pbi.getIsPregnantwoman());
			pwi.setMarryhistory(pbi.getMarryhistory());
			pwiService.add(pwi);
			pwgh.setId(pwi.getId());
			pwgh.setPsychosis(gh.getPsychosis());
			pwgh.setPsychosisdescribe(gh.getPsychosisdescribe());
			pwgh.setDementia(gh.getDementia());
			NowTimeUtil timeUtil=new NowTimeUtil();
			pwi.setChecktime(timeUtil.getNowTime());
			pwgh.setDementiadescribe(gh.getDementiadescribe());
			pwgh.setGeneticdisease(gh.getGeneticdisease());
			pwgh.setGeneticdiseasedescribe(gh.getGeneticdiseasedescribe());
			pwgh.setMalformation(gh.getMalformation());
			pwgh.setMalformationdescribe(gh.getMalformationdescribe());
			prewomanGeneticHistoryService.add(pwgh);
			pbisService.delete(id);
			ghService.delete(id);
			ar=new AjaxResult("转换成功!");
		} catch (Exception e) {
			e.printStackTrace();
			ar=new AjaxResult("转换失败!"+e.getMessage(),-1001);
		}
		return ar;
	}
	
	/**
	 * 添加和修改，保存人员基本信息
	 * @param pwiService
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(PregnantWomanInformation pwi,PrewomanGeneticHistory pwgh,AbnormalMaternalHistory amh){
		AjaxResult ar = null;
		NowTimeUtil time= new NowTimeUtil();
		try {
			if (pwi.getId()==null) {
				//添加
				pwi.setChecktime(time.getNowTime());
				pwiService.add(pwi);
				pwgh.setId(pwi.getId());
				amh.setId(pwi.getId());
				amh.setPrewomanid(pwi.getIdnumber());
				prewomanGeneticHistoryService.add(pwgh);
				amhService.add(amh);
			} else {
				PregnantWomanInformation one = pwiService.getOne(pwi.getId());
				List<PremaritaHealthInformation> byidnumber = phiService.selectAllByidnumber(pwi.getIdnumber());
				List<AntenatalInitialInspection> byidnumber2 = AiiService.selectAllByidnumber(pwi.getIdnumber());
				List<PrenatalReviewRecord> byidnumber3 = prrService.selectAllByidnumber(pwi.getIdnumber());
				if (pwi.getIdnumber().equals(one.getIdnumber()) && byidnumber.size()>0) {
					pwiService.update(pwi);
					prewomanGeneticHistoryService.update(pwgh);
					amhService.update(amh);
					for (PremaritaHealthInformation phi : byidnumber) {
						phi.setPreidnumber(pwi.getIdnumber());
						phi.setPrename(pwi.getName());
						phiService.update(phi);
					}
					if (pwi.getIdnumber().equals(one.getIdnumber()) && byidnumber2.size()>0) {
						for (AntenatalInitialInspection Aii : byidnumber2) {
							Aii.setPeidnumber(pwi.getIdnumber());
							Aii.setPrename(pwi.getName());
							Aii.setPrephonenumber(pwi.getPhonenumber());
							Aii.setHealthcode(pwi.getHealthcode());
							AiiService.update(Aii);
						}
						if (pwi.getIdnumber().equals(one.getIdnumber()) && byidnumber3.size()>0) {
							for (PrenatalReviewRecord prr : byidnumber3) {
								prr.setPreidnumber(pwi.getIdnumber());
								prr.setPrename(pwi.getName());
								prr.setPrephonenumber(pwi.getPhonenumber());
								prr.setHealthcode(pwi.getHealthcode());
								prrService.update(prr);
							}
						}
					}
				}else {
					pwiService.update(pwi);
					prewomanGeneticHistoryService.update(pwgh);
					amhService.update(amh);
				}
			}
			ar=new AjaxResult("保存成功!");
		}catch (Exception e) {
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
	
	@RequestMapping("/idnumber")
	@ResponseBody
	public List<PersonBasicInformation> getIDnumber(){
		return pbisService.selectIDnumber();
	}
}
