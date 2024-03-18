package com.doctorapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    IDoctorService doctorService=new DoctorServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		Doctor doctor=new Doctor();
		
		String doctorname=request.getParameter("doctorName");
		String speciality=request.getParameter("speciality");
		String srating=request.getParameter("rating");
		String exp=request.getParameter("exp");
		String fee=request.getParameter("fees");
		
		int experience=Integer.parseInt(exp);
		int rating=Integer.parseInt(srating);
		double fees=Double.parseDouble(fee);
		
		doctor.setDoctorName(doctorname);
		doctor.setSpeciality(speciality);
		doctor.setExperience(experience);
		doctor.setRating(rating);
		doctor.setFees(fees);
		
		doctorService.addDoctor(doctor);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("adminDash.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
