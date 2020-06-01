import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import service.INewbornSituationService;

public class NewbornSituationTest extends BaseTest{
	
	@Autowired
	private INewbornSituationService nss;
	
	@Test
	public void test() {
		System.out.println(nss.getAll());
	}

}
