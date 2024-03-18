package com.doctorapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DoctorDb;
import com.doctorapp.util.Queries;

public class DoctorRepositoryImpl implements IDoctorRepository{
	  @Override
	    public void addDoctor(Doctor doctor) {
	        //establish a connection
	        //create a prepared statement
	        //set values for placeholders
	        //call execute

	        try (Connection connection = DoctorDb.openConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(Queries.InsertQuery);
	        ) {
	            preparedStatement.setString(1, doctor.getDoctorName());
	            preparedStatement.setString(2, doctor.getSpeciality());
	            preparedStatement.setDouble(3, doctor.getFees());
	            preparedStatement.setInt(4, doctor.getRating());
	            preparedStatement.setInt(5, doctor.getExperience());
	            //call execute
	            boolean result = preparedStatement.execute();
	            System.out.println("one row inserted");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public void updateDoctor(int doctorId, double fees) {
	        try (Connection connection = DoctorDb.openConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(Queries.UpdateQuery);
	        ) {
	            preparedStatement.setDouble(1, fees);
	            preparedStatement.setInt(4, doctorId);
	            boolean result = preparedStatement.execute();
	            System.out.println("One row updated" + !result);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteDoctors(int doctorId) {

	    }

	    @Override
	    public Doctor findById(int doctorId) {
	        return null;
	    }

	    @Override
	    public List<Doctor> findAll() {
	        //establish a connection
	        //create empty list
	        //create a prepared statement
	        //call executequery
	        //iterate resultset //get column values
	        //create a doctor object and set values of column using setter
	        //add doctor to list(inside loop)
	        //return doctorList
	        List<Doctor> doctors = new ArrayList<>();
	        try (Connection connection = DoctorDb.openConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(Queries.findAllQuery);
	             ResultSet resultSet = preparedStatement.executeQuery();

	        ) {
	            while (resultSet.next()) {
	                int doctorId = resultSet.getInt("doctor_id");
	                String doctorName = resultSet.getString("doctor_name");
	                String speciality = resultSet.getString("speciality");
	                double fees = resultSet.getFloat("fees");
	                int ratings = resultSet.getInt("ratings");
	                int experience = resultSet.getInt("experience");
	                Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
	                doctors.add(doctor);
	            }
	            return doctors;
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }}
	        @Override
	        public List<Doctor> findBySpeciality (String speciality) {
	            List<Doctor> doctors = new ArrayList<>();
	            try (Connection connection = DoctorDb.openConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(Queries.findBySpeciality);
	            ) {
	                System.out.println(speciality);
	                preparedStatement.setString(1,speciality);
	                try( ResultSet resultSet = preparedStatement.executeQuery();) {
	                    while (resultSet.next()){
	                        int doctorId = resultSet.getInt("doctor_id");
	                        String doctorName = resultSet.getString("doctor_name");
	                        double fees = resultSet.getFloat("fees");
	                        int ratings = resultSet.getInt("ratings");
	                        int experience = resultSet.getInt("experience");
	                        Doctor doctor=new Doctor();
	                        doctor.setDoctorId(doctorId);
	                        doctor.setDoctorName(doctorName);
	                        doctor.setSpeciality(speciality);
	                        doctor.setFees(fees);
	                        doctor.setRating(ratings);
	                        doctor.setExperience(experience);

	                        doctors.add(doctor);
	                    }
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return doctors;
	        }
	            @Override
	        public List<Doctor> findBySpecialityAndExp(String speciality,int experience){
	                List<Doctor> doctors = new ArrayList<>();
	                try (Connection connection = DoctorDb.openConnection();
	                     PreparedStatement preparedStatement = connection.prepareStatement(Queries.findBySpecialityAndExp);
	                ) {
	                    preparedStatement.setString(1,speciality);
	                    preparedStatement.setInt(1,experience);
	                    try( ResultSet resultSet = preparedStatement.executeQuery();) {
	                        while (resultSet.next()){
	                            int doctorId = resultSet.getInt("doctor_id");
	                            String doctorName = resultSet.getString("doctor_name");
	                            double fees = resultSet.getFloat("fees");
	                            int ratings = resultSet.getInt("ratings");
	                            Doctor doctor=new Doctor();
	                            doctor.setDoctorId(doctorId);
	                            doctor.setDoctorName(doctorName);
	                            doctor.setSpeciality(speciality);
	                            doctor.setFees(fees);
	                            doctor.setRating(ratings);
	                            doctor.setExperience(experience);

	                            doctors.add(doctor);
	                        }
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            return doctors;
	        }

	        @Override
	        public List<Doctor> findBySpecialityAndLessFees (String speciality,double fees){
	            List<Doctor> doctors = new ArrayList<>();
	            try (Connection connection = DoctorDb.openConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(Queries.findBySpecialityAndLessFees);
	            ) {
	                preparedStatement.setString(1,speciality);
	                preparedStatement.setDouble(1,fees);
	                try( ResultSet resultSet = preparedStatement.executeQuery();) {
	                    while (resultSet.next()){
	                        int doctorId = resultSet.getInt("doctor_id");
	                        String doctorName = resultSet.getString("doctor_name");
	                        int ratings = resultSet.getInt("ratings");
	                        int experience = resultSet.getInt("experience");
	                        Doctor doctor=new Doctor();
	                        doctor.setDoctorId(doctorId);
	                        doctor.setDoctorName(doctorName);
	                        doctor.setSpeciality(speciality);
	                        doctor.setFees(fees);
	                        doctor.setRating(ratings);
	                        doctor.setExperience(experience);

	                        doctors.add(doctor);
	                    }
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return null;
	        }

	        @Override
	        public List<Doctor> findBySpecialityAndRatings (String speciality,int ratings){
	            List<Doctor> doctors = new ArrayList<>();
	            try (Connection connection = DoctorDb.openConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(Queries.findBySpecialityAndRatings);
	            ) {
	                preparedStatement.setString(1,speciality);
	                preparedStatement.setInt(1,ratings);
	                try( ResultSet resultSet = preparedStatement.executeQuery();) {
	                    while (resultSet.next()){
	                        int doctorId = resultSet.getInt("doctor_id");
	                        String doctorName = resultSet.getString("doctor_name");
	                        double fees = resultSet.getFloat("fees");
	                        int experience = resultSet.getInt("experience");
	                        Doctor doctor=new Doctor();
	                        doctor.setDoctorId(doctorId);
	                        doctor.setDoctorName(doctorName);
	                        doctor.setSpeciality(speciality);
	                        doctor.setFees(fees);
	                        doctor.setRating(ratings);
	                        doctor.setExperience(experience);

	                        doctors.add(doctor);
	                    }
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return doctors;
	        }

	        @Override
	        public List<Doctor> findBySpecialityAndName (String speciality, String name){
	            List<Doctor> doctors = new ArrayList<>();
	            try (Connection connection = DoctorDb.openConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(Queries.findBySpecialityAndName);
	            ) {
	                preparedStatement.setString(1,speciality);
	                preparedStatement.setString(1,name);
	                try( ResultSet resultSet = preparedStatement.executeQuery();) {
	                    while (resultSet.next()){
	                        int doctorId = resultSet.getInt("doctor_id");
	                        String doctorName = resultSet.getString("doctor_name");
	                        double fees = resultSet.getFloat("fees");
	                        int ratings = resultSet.getInt("ratings");
	                        int experience = resultSet.getInt("experience");
	                        Doctor doctor=new Doctor();
	                        doctor.setDoctorId(doctorId);
	                        doctor.setDoctorName(doctorName);
	                        doctor.setSpeciality(speciality);
	                        doctor.setFees(fees);
	                        doctor.setRating(ratings);
	                        doctor.setExperience(experience);

	                        doctors.add(doctor);
	                    }
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return null;
	        }
}
