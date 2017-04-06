package com.rex.dao.impl;

import java.text.SimpleDateFormat;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.XMLWriter;

import com.rex.dao.UserDao;
import com.rex.domain.User;
import com.rex.utils.XmlUtils;

public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.rex.dao.impl.UserDao#add(com.rex.domain.User)
	 */
	@Override
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
			Element user_tagElement = root.addElement("user");
			user_tagElement.setAttributeValue("id",user.getId());
			user_tagElement.setAttributeValue("username",user.getUsername());
			user_tagElement.setAttributeValue("password",user.getPassword());
			user_tagElement.setAttributeValue("email",user.getEmail());
			user_tagElement.setAttributeValue("birthday",user.getBirthday()==null?"":user.getBirthday().toString());
			user_tagElement.setAttributeValue("nickname",user.getNickname());
			
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.rex.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username,String password){
		try {
			Document document= XmlUtils.getDocument();
			
			
			String pathString = "//user[@username='"+username+"'and @password='"+password+"']";

			Element element = (Element) document.selectSingleNode(pathString);
			System.out.println("find element");
			if(element ==null){
				return null;
			}
			User user =new User();
			String date= element.attributeValue("birthday");
			if(date == null || date.equals("")){
				user.setBirthday("");
			}
			else{
				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(dFormat.parse(date).toString());
			}
			
			user.setEmail(element.attributeValue("email"));
			user.setId(element.attributeValue("id"));
			user.setNickname(element.attributeValue("nickname"));
			user.setPassword(element.attributeValue("password"));
			user.setUsername(element.attributeValue("username"));
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
			
	}
	
	/* (non-Javadoc)
	 * @see com.rex.dao.impl.UserDao#find(java.lang.String)
	 */
	@Override
	public boolean find(String username){		
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(element == null){
				return false;
			}
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}	
	}
}
