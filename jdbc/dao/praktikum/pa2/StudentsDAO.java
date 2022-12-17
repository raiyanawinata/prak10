package com.ibik.pbo.teori.jdbc.dao.praktikum.pa2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentsDAO {

	private String query = "INSERT INTO `student`(`npm`, `firstname`, `middlename`, `lastname`, `email`, `birthday`) VALUES (?,?,?,?,?,?) ";
	
	public void saved(Students students) throws Exception {
		 
		 Connection c = new ConnectionDB().connect();
		 
		 PreparedStatement psInsert = c.prepareStatement(query);
		 
		 psInsert.setInt(1, students.getNpm());
		 psInsert.setString(2, students.getFirstname());
		 psInsert.setString(3, students.getMiddlename());
		 psInsert.setString(4, students.getLastname());
		 psInsert.setString(5, students.getEmail());
		 psInsert.setString(6, students.getBirthday());
		 
		 psInsert.executeUpdate();
		 
		 c.close();
		 }
		}

