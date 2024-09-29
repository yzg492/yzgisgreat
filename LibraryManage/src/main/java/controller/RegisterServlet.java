package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		String pwd1 = request.getParameter("pwdName1");
		String pwd2 = request.getParameter("pwdName2");				
		User user = new User();			
		user.setUsername(request.getParameter("userName"));		
		if(pwd1.equals(pwd2)){			
			user.setPassword(pwd1);					
			int row = userService.register(user);
			System.out.println("改变的行数："+row);					
			if (row > 0) {
				System.out.println("注册成功");				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {				
				System.out.println("注册失败");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}			
		}else {
			System.out.println("两次密码不同，登录失败");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
	}

}