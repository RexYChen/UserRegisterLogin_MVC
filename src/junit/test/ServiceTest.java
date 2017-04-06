package junit.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.rex.domain.User;
import com.rex.exception.UserExistException;
import com.rex.service.impl.BusinessService;
import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class ServiceTest {

	@Test
	public void testRegister(){
		User user = new User();
		
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dataString = sDateFormat.format(new Date());
		
		user.setBirthday(dataString);
		user.setUsername("aaa");
		user.setPassword("123");
		user.setEmail("bbbb@163.com");
		user.setNickname("b1");
		user.setId("0002");
		
		BusinessService bService=new BusinessService();
		try {
			bService.register(user);
			System.out.println("Register successful");
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			System.out.println("User exist");
		}
	}
	
	@Test
	public void testLogin(){
		String username= "aaa";
		String password = "123";
		
		BusinessService bService=new BusinessService();
		
		User user = bService.login(username, password);
		
		if(user ==null){
			System.out.println("User not exist,please register first");
		}
		else {
			System.out.println("User Login success, Username is" + user.getUsername());
		}
		
	}
}
