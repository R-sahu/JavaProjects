package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	
private DataSource ds =null;
private Connection con =null;
private PreparedStatement ps =null; 
int count =0;

private static final String INSERT_QUERY ="INSERT INTO LAYERED_APPLICATION VALUES(?,?,?,?,?,?)";
	
	public StudentDAOImpl(DataSource ds) {
		this.ds =ds;
	}

	@Override
	public int insert(StudentBO bo) throws Exception {
		
		//get the connection object from conn pool
		con=ds.getConnection();
		
		//create prepared statement object
		ps =con.prepareStatement(INSERT_QUERY);
		
		//set the query params
		ps.setInt(1, bo.getSno());
		ps.setString(2,bo.getSname());
		ps.setString(3, bo.getSaddr());
		ps.setInt(4, bo.getTotal());
		ps.setFloat(5, bo.getAvg());
		ps.setString(6, bo.getResult());
		
		count =ps.executeUpdate();
		
		return count;
	}

}
