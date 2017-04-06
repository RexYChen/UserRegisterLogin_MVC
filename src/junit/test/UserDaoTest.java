package junit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.rex.dao.UserDao;
import com.rex.dao.impl.UserDaoImpl;
import com.rex.domain.User;

public class UserDaoTest {

	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date().toString());
		user.setUsername("ccc");
		user.setPassword("123");
		user.setEmail("bbbb@163.com");
		user.setNickname("b1");
		user.setId("0002");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		dao.find("aaa","123");
		System.out.println(dao.find("aaa", "123").toString());
	}
}
