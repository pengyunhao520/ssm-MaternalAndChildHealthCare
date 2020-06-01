

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.PersonBasicInformation;
import domain.PregnantWomanInformation;
import query.PersonBasicInformationQuery;
import query.PregnantWomanInformationQuery;
import service.IPregnantWomanInformationService;
import util.PageList;

public class IPregnantWomanInformationServiceTest extends BaseTest{

	@Autowired
	private IPregnantWomanInformationService pwiService;
	
	@Test
	public void testDelete() {
		PregnantWomanInformation pwi= new PregnantWomanInformation();
		Integer id;
		id=20;
		pwi.setId(id);
		System.out.println(pwi);
		pwiService.add(pwi);
	}

	@Test
	public void testAdd() {
		
	}

	@Test
	public void testGetOne() {
		PregnantWomanInformation one = pwiService.getOne(10L);
		Date date = new Date();//获得系统时间.
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd" );
		String nowTime = sdf.format(date); 
		one.setChecktime(date);
		pwiService.update(one);
		System.out.println(one);
	}

	@Test
	public void testGetAll() {
		List<PregnantWomanInformation> list = pwiService.getAll();
		System.out.println(list);
	}

	@Test
	public void testUpdate() {
		List<PregnantWomanInformation> list = pwiService.selectAllByhusbandid(57);
		System.out.println(list);
		for (PregnantWomanInformation p : list) {
			System.out.println(p);
		}
	}

	@Test
	public void testGetByQuery() {
		PregnantWomanInformationQuery pq = new PregnantWomanInformationQuery();
		//pq.setIS_Birth("已生育");
		pq.setQ("女");
		
		pq.setPage(1);
		pq.setRows(3);
		PageList<PregnantWomanInformation> pageList = pwiService.getByQuery(pq);
		System.out.println("总条目数："+pageList.getTotal());
		System.out.println("当前页数据：");
		for (PregnantWomanInformation p : pageList.getRows()){
			System.out.println(p);
		}
	}
}
