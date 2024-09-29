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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import service.AppointmentService;
import utils.DBUtils;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String id = request.getParameter("id");
	    request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	    // 将字符串转换为整数，根据需要处理转换异常
	    int intId = Integer.parseInt(id);
		 AppointmentService a=new AppointmentService();
		 a.undo(intId);
		  response.sendRedirect("appointment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
//		 Integer  i=(Integer )session.getAttribute("myid");
        HttpSession session = request.getSession();
     int attributeValue = (int) session.getAttribute("myid");
	
		String i=request.getParameter("id");
        String appointmentDate = request.getParameter("date");
        String department = request.getParameter("doctor_id");
        
        // 连接数据库，执行插入操作
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement p = null;
        ResultSet rs = null; ResultSet r= null;
        try {
            conn = DBUtils.getConnection();
           
          String dd=appointmentDate;
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date date = formatter.parse(dd);
          Date sqlDate = new Date(date.getTime());
          System.out.println(date);
            System.out.println(Date.valueOf(appointmentDate));
            String s="SELECT max_appointments FROM doctor_schedule WHERE doctor_id ="
            + department+" AND schedule_time =?";
            p = conn.prepareStatement(s);
            p.setDate(1, sqlDate);
            r=p.executeQuery();
            int ii = 0;
            if (r.next()) {
             ii=  r.getInt(1) ;
            }
            System.out.println("ii="+ii);
            if(ii<=0)
            {   
            	System.out.println(ii+"   "+i);
            	int option = JOptionPane.showConfirmDialog(null, "预约失败，当日该医生无排班", "确认", JOptionPane.OK_CANCEL_OPTION);
            	
            	if (option == JOptionPane.OK_OPTION) 
            	{ response.sendRedirect("appointmentForm.jsp");}
            	else
            	{
            		response.sendRedirect("loginSuccess.jsp");
            	}
            }
            else {
            	String sq="SELECT COUNT(*) from appointment WHERE doctor_id ="+department+" AND date= ?";
            	p=conn.prepareStatement(sq);
            	p.setDate(1, sqlDate);
            	r=p.executeQuery();
            	int iii=0;
            	if(r.next())
            	{
            		iii=r.getInt(1);
            	}
            	 System.out.println("iii="+iii);
            	if(ii<=iii)
            	{
            		int option = JOptionPane.showConfirmDialog(null, "预约失败，当日预约该医生的数量超过该医生设置的最大预约数量", "确认", JOptionPane.OK_CANCEL_OPTION);
                	
                	if (option == JOptionPane.OK_OPTION) 
                	{ response.sendRedirect("appointmentForm.jsp");}
                	else
                	{
                		response.sendRedirect("loginSuccess.jsp");
                	}
            		
            	}
            
            	else {
            String sql = "INSERT INTO appointment (user_id, doctor_id,date,  status) VALUES (?, ?, ?, '待叫号')";
            pstmt = conn.prepareStatement(sql);
            int option = JOptionPane.showConfirmDialog(null, "预约成功！", "确认", JOptionPane.OK_CANCEL_OPTION);
        	
            pstmt.setString(1, i );
            pstmt.setDate(3, Date.valueOf(appointmentDate));
            pstmt.setString(2, department);
            pstmt.executeUpdate();
            rs = pstmt.executeQuery();
        	if (option == JOptionPane.OK_OPTION) 
        	{ response.sendRedirect("appointmentForm.jsp");}
        	else
            response.sendRedirect("loginSuccess.jsp");}
            }
            }
         catch (SQLException e) {
            e.printStackTrace();         
            response.sendRedirect("loginSuccess.jsp");
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

