package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Doctor;
import entity.User;
import service.DoctorService;
import service.UserService;

/**
 * Servlet implementation class AdddoctorServlet
 */
@WebServlet("/AdddoctorServlet")
public class AdddoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdddoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private DoctorService doctorService = new DoctorService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String d=request.getParameter("department");
		System.out.println("department="+d);
		Doctor doctor = new Doctor();			
		 doctor.setName(request.getParameter("id"));
		doctor.setDepartment(d);
		if(pwd1.equals(pwd2)){	
			 doctor.setPassword(pwd1);					
			int row = doctorService.register(doctor);
			System.out.println("改变的行数："+row);			
			if (row > 0) {
				System.out.println("添加成功");
				request.getRequestDispatcher("doctorlista.jsp").forward(request, response);
			} else {
				System.out.println("添加失败");
				request.getRequestDispatcher("adddoctor.jsp").forward(request, response);
			}
			
		}else {
			System.out.println("两次密码不同，登录失败");
			request.getRequestDispatcher("adddoctor.jsp").forward(request, response);
		}
		
	}

}
