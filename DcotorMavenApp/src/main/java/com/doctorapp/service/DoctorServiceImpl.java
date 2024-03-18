package com.doctorapp.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.DoctorRepositoryImpl;
import com.doctorapp.repository.IDoctorRepository;

public class DoctorServiceImpl implements IDoctorService{
	 private IDoctorRepository doctorRepository=new DoctorRepositoryImpl();
	    @Override
	    public void addDoctor(Doctor doctor) {
	        doctorRepository.addDoctor(doctor);
	    }

	    @Override
	    public void updateDoctor(int doctorId, double fees) {

	    }

	    @Override
	    public void deleteDoctors(int doctorId) {

	    }

	    @Override
	    public Doctor getById(int doctorId)throws IdNotFoundException {
	        Doctor doctor=doctorRepository.findById(doctorId);
	        if (doctor==null)
	            throw new IdNotFoundException("Invalid Id");
	        return doctor;
	    }

	    @Override
	    public List<Doctor> getAll() {
	        List<Doctor> doctors= doctorRepository.findAll();
	        return doctors;
	    }

	    @Override
	    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException, SQLException {
	        List<Doctor>doctors=doctorRepository.findBySpeciality(speciality);
	        if (doctors.isEmpty())
	            throw new DoctorNotFoundException("doctor with this speciality not found");
	        Collections.sort(doctors,(d1,d2)->d1.getDoctorName().compareTo(d2.getDoctorName()));
	        return doctors;
	    }

	    @Override
	    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
	        List<Doctor>doctors=doctorRepository.findBySpecialityAndExp(speciality,experience);
	        if (doctors.isEmpty())
	            throw new DoctorNotFoundException("doctor with this speciality and exp not found");
	        Collections.sort(doctors,(d1,d2)->((Integer)(d2.getExperience())).compareTo(d1.getExperience()));
	        return doctors;
	    }

	    @Override
	    public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
	        List<Doctor> doctors=doctorRepository.findBySpecialityAndLessFees(speciality,fees);
	        if (doctors.isEmpty())
	            throw  new DoctorNotFoundException("doctor with this speciality and fees not found");
	        Collections.sort(doctors,(d1,d2)->((Double)(d1.getFees())).compareTo(d2.getFees()));
	        return doctors;
	    }

	    @Override
	    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
	        List<Doctor> doctors=doctorRepository.findBySpecialityAndRatings(speciality,ratings);
	        if (doctors.isEmpty())
	            throw new DoctorNotFoundException("doctor with this speciality and ratings not found");
	        Collections.sort(doctors,(d1,d2)->((Integer)(d2.getRating())).compareTo(d1.getRating()));
	        return doctors;
	    }

	    @Override
	    public List<Doctor> getBySpecialityAndName(String speciality, String name) throws DoctorNotFoundException {
	        List<Doctor> doctors=doctorRepository.findBySpecialityAndName(speciality,name);
	        if (doctors.isEmpty())
	            throw new DoctorNotFoundException("doctor with this speciality and name not found");
	           Collections.sort(doctors,(d1,d2)->(d2.getDoctorName().compareTo(d2.getDoctorName())));
	        return doctors;
	    }
}
