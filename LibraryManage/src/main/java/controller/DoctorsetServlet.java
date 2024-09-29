package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.AppointmentService;
import utils.DBUtils;

/**
 * Servlet implementation class DoctorsetServlet
 */
@WebServlet("/DoctorsetServlet")
public class DoctorsetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorsetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");
		  
		    int intId = Integer.parseInt(id);
			 AppointmentService a=new AppointmentService();
			 a.doctorundo(intId);
			  response.sendRedirect("personaltreat.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String i=request.getParameter("id");
        String a= request.getParameter("date");
        String d= request.getParameter("number");
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement p = null;
        ResultSet rs = null; ResultSet r= null;
        try {
            conn = DBUtils.getConnection();
           
          String dd=a;
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date date = formatter.parse(dd);
          Date sqlDate = new Date(date.getTime());
          System.out.println(date);
            System.out.println(Date.valueOf(a));
            String s = "INSERT INTO doctor_schedule ( doctor_id,schedule_time, max_appointments) VALUES (?, ?, ?)";
           
            p = conn.prepareStatement(s);
            p.setDate(2, sqlDate);
            p.setString(1, i);
            p.setString(3, d);
            p.executeUpdate();
            r=p.executeQuery();
           
           
             
            }
         catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("loginSuccessd.jsp");
        } catch (ParseException e) {	
			e.printStackTrace();
		} finally {          
        	 try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
             try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
             try { if (r != null) r.close(); } catch (Exception e) { e.printStackTrace(); }
             try { if (p != null) p.close(); } catch (Exception e) { e.printStackTrace(); }
             try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
	}

}
