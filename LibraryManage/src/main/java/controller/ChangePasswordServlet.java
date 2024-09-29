package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBUtils;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()修改医生密码
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        HttpSession sn=request.getSession();
     	String i=request.getParameter("id");
     	int id = Integer.parseInt(i);
     	Connection con=null;
     	ResultSet  rs =null;
		 PreparedStatement pstmt=null;
		try {
			con = DBUtils.getConnection();
			String sql="select password from doctor where doctor_id="+id;
			  pstmt =con.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 boolean is=false;
			 if(rs.next())
			 {
				 System.out.println("password="+rs.getString("password"));
				 is=currentPassword.equals(rs.getString("password"));
				if(is)
					System.out.println("true");
				else
					System.out.println("falses");
			 }
	        if (!newPassword.equals(confirmNewPassword)) {
	            response.setContentType("text/html; charset=utf-8");
	            PrintWriter out = response.getWriter();
	            out.println("<!DOCTYPE html>");
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<title>Login Failed</title>");
		        out.println("<script type='text/javascript'>");
		        out.println("window.onload = function() {");
		        out.println("  alert('新密码和确认新密码不匹配！');");
		        out.println("  window.location.href='loginSuccessd.jsp';"); // 跳转到登录页面
		        out.println("};");
		        out.println("</script>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("</body>");
		        out.println("</html>");
	          
	            return;
	        }
	        
	        if (!is) {
	            response.setContentType("text/html; charset=utf-8");
	            PrintWriter out = response.getWriter();
	         
	            out.println("<!DOCTYPE html>");
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<title>Login Failed</title>");
		        out.println("<script type='text/javascript'>");
		        out.println("window.onload = function() {");
		        out.println("  alert('当前密码不正确！');");
		        out.println("  window.location.href='loginSuccessd.jsp';"); 
		        out.println("};");
		        out.println("</script>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("</body>");
		        out.println("</html>");
	          
	            return;
	        }
	        
	       
	        sql="UPDATE doctor SET password ="+newPassword+" where doctor_id="+id;
	        pstmt=con.prepareStatement(sql);
	      int r=pstmt.executeUpdate();
	        if (r>0) {
	            response.setContentType("text/html; charset=utf-8");
	            PrintWriter out = response.getWriter();
	           
	            out.println("<!DOCTYPE html>");
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<title>Login Failed</title>");
		        out.println("<script type='text/javascript'>");
		        out.println("window.onload = function() {");
		        out.println("  alert('密码已成功更新！');");
		        out.println("  window.location.href='loginSuccessd.jsp';"); 
		        out.println("};");
		        out.println("</script>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("</body>");
		        out.println("</html>");
	          
	        } else {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	        
	            out.println("<!DOCTYPE html>");
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<title>Login Failed</title>");
		        out.println("<script type='text/javascript'>");
		        out.println("window.onload = function() {");
		        out.println("  alert('密码更新失败，请联系管理员！');");
		        out.println("  window.location.href='loginSuccessd.jsp';"); 
		        out.println("};");
		        out.println("</script>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("</body>");
		        out.println("</html>");
	          
	        }
		} catch (Exception e) {
			
			e.printStackTrace();
		}    finally {
			
			try {
				DBUtils.close(rs, pstmt, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    }
    
    
    	
    	
       
    


}
