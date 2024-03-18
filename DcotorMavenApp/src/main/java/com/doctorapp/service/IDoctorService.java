package com.doctorapp.service;

import java.sql.SQLException;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	 void addDoctor(Doctor doctor);

	    void updateDoctor(int doctorId,double fees);

	    void deleteDoctors(int doctorId);

	    Doctor getById(int doctorId)throws IdNotFoundException;

	    List<Doctor> getAll();
	    List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException, SQLException;

	    List<Doctor> getBySpecialityAndExp(String speciality,int experience)throws DoctorNotFoundException;

	    List<Doctor> getBySpecialityAndLessFees(String speciality,double fees)throws DoctorNotFoundException;

	    List<Doctor> getBySpecialityAndRatings(String speciality,int ratings)throws DoctorNotFoundException;

	    List<Doctor> getBySpecialityAndName(String speciality,String name)throws DoctorNotFoundException;

}
