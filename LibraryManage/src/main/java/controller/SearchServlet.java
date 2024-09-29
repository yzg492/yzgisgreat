package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Doctor;
import entity.Doctor_schedule;
import service.AppointmentService;
import service.DoctorService1;
import service.SearchService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String department = request.getParameter("department");
		
		String doctor = request.getParameter("doctor");
		String date = request.getParameter("date");
		String title = request.getParameter("title");
		 System.out.println("depart="+title);
		 DoctorService1 doctorService1 = new DoctorService1();		   
	        Map.Entry<List<Doctor>, List<Doctor_schedule>> entry = SearchService.getLists(doctor,department,date,title);
	        List<Doctor> list1 = entry.getKey();
	        List<Doctor_schedule> list2 = entry.getValue();
		    request.setAttribute("doctorList", list1);
		    request.setAttribute("appointmentList", list2);		
		    RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		    dispatcher.forward(request, response);
	}

}
