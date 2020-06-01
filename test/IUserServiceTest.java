

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.User;
import service.IUserService;

public class IUserServiceTest extends BaseTest{

	@Autowired
	private IUserService userServer;
	
	
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		User user=userServer.getOne(1L);
		user.setPassword("111");
		userServer.add(user);
	}

	@Test
	public void testGetOne() {
		User user1=userServer.getOne(1L);
		System.out.println(user1);
		
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByQuery() {
	
	}

}
