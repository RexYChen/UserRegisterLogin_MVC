package com.rex.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rex.domain.User;
import com.rex.exception.UserExistException;
import com.rex.service.impl.BusinessService;
import com.rex.utils.WebUtils;
import com.rex.web.formbean.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. verify data format (formbean)
		
		request.setCharacterEncoding("UTF-8");
		
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		
		boolean b = form.Validate();
		
		//2. if verify fail, return form page and send fail message
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3. if verify success, call service handle register request
		User user = new User();
		WebUtils.copyBean(form, user);	
		user.setId(WebUtils.generateID());
		BusinessService bService = new BusinessService();
		try {
			bService.register(user);
			
			//6. if service handle success. return web global success message page
			request.setAttribute("message", "Congratulation you sign up successful");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		} catch (UserExistException e) {
			//4. if service handle fail. user exist return register page send fail message
			form.getErrorsMap().put("username", "User already exist");
			request.setAttribute("form", form);
			
			//request.setAttribute("message", "User already exist");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		catch (Exception e) {
			//5. if service handle fail. other problem return web global message page
			request.setAttribute("message", "Service Error");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
