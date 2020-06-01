import static org.junit.Assert.*;

import java.awt.print.Printable;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.PersonBasicInformation;
import domain.PregnantWomanInformation;
import query.PersonBasicInformationQuery;
import service.IPersonBasicInformationService;
import service.IPregnantWomanInformationService;
import util.PageList;

public class IPersonBasicInformationServiceTest extends BaseTest{

	@Autowired
	private IPersonBasicInformationService pbis;
	
	@Autowired
	private IPregnantWomanInformationService pwiService;
	
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		PregnantWomanInformation pwi = pwiService.getOne(12L);
		PersonBasicInformation pbi=new PersonBasicInformation();
		pbi.setHealthcode(pwi.getHealthcode());
		pbi.setName(pwi.getName());
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
		pbis.add(pbi);
		
	}

	@Test
	public void testGetOne() {
		PersonBasicInformation one = pbis.getOne(1L);
		
	}

	@Test
	public void testGetAll() {
		List<PersonBasicInformation> list = pbis.getAll();
		for (PersonBasicInformation personBasicInformation : list) {
			System.out.println(personBasicInformation);
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByQuery() {
		PersonBasicInformationQuery pq = new PersonBasicInformationQuery();
		//pq.setIS_Birth("已生育");
		pq.setQ("女");
		
		pq.setPage(1);
		pq.setRows(3);
		PageList<PersonBasicInformation> pageList = pbis.getByQuery(pq);
		System.out.println("总条目数："+pageList.getTotal());
		System.out.println("当前页数据：");
		for (PersonBasicInformation p : pageList.getRows()){
			System.out.println(p);
		}
	
	
	}

}
