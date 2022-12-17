package com.ibik.pbo.teori.jdbc.dao.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibik.pbo.teori.jdbc.dao.praktikum.pa1.ConnectDb;

public class StudentsDao {
	
	private String sqlInsert = "insert into students (firstname, email, npm) " + "values (?,?,?)";

    public void saved(Students students) throws Exception {
        Connection c = new ConnectDb().connect();
        
            PreparedStatement psInsert = c.prepareStatement(sqlInsert);
            psInsert.setString(1, students.getFirstname());
            psInsert.setString(2, students.getEmail());
            psInsert.setString(3, students.getNpm());
            psInsert.executeUpdate();
        
        c.close();
    }

}
