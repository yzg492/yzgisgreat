package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import entity.Doctor;
import entity.User;
import service.AdminService;
import service.DoctorService;
import service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private AdminService adminService = new AdminService();
	private DoctorService doctorService = new DoctorService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String parm=request.getParameter("role");
		String username = (String)request.getParameter("userName");
		String password = request.getParameter("pwdName");
		User user=null;Doctor doctor=null;Admin admin=null;
		if("user".equals(parm)) {
		 user = userService.login(username,password);}
		if("admin".equals(parm)) {
			admin = adminService.login(username,password);}			
		if("doctor".equals(parm)) {
			System.out.println("1");
			 doctor=doctorService.login(username,password);}			
		System.out.println(user==null);		
		if (user != null||doctor!=null||admin!=null) {
			System.out.println("登录成功");
			
			/*
			待解决问题，1.代码冗余 2.代码美化
			3.预约逻辑不够，比如设置不能预约在同一天两次及以上
			 * */
			HttpSession session = request.getSession();
			session.setAttribute("user",username);
			
			if(user!=null)
			
		{
				int i=user.getId();
				System.out.println(i);
				session.setAttribute("myid", i);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);}			
			if(doctor!=null)
				{
				int i=doctor.getDoctor_id();
				System.out.println(i);
				session.setAttribute("myid", i);
			System.out.println("zzz");
				request.getRequestDispatcher("loginSuccessd.jsp").forward(request, response);
				}
			if(admin!=null) {
				int i=admin.getId();
				System.out.println(i);
				session.setAttribute("myid", i);
			System.out.println("zzz");
				request.getRequestDispatcher("loginSuccessa.jsp").forward(request, response);
			}
		} else {			
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter out = response.getWriter();
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Login Failed</title>");
	        out.println("<script type='text/javascript'>");
	        out.println("window.onload = function() {");
	        out.println("  alert('登录失败，请重新输入！');");
	        out.println("  window.location.href='index.jsp';"); 
	        out.println("};");
	        out.println("</script>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("</body>");
	        out.println("</html>");
			System.out.println("登陆失败");		
		}			
	}
}