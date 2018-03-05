package com.jga.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jga.models.Developer;

public class AddressDao {
	public static AddressDao instance=null;
	public static AddressDao getInstance() {
		if(instance == null) {
			instance=new AddressDao();
		}
		return instance;
	}
	private AddressDao() {}
	
	

	public void deletePrimaryAddressForDeveloper(int i) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "DELETE FROM Address WHERE id=? AND primary=1";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		stmt.executeUpdate();		
	    
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

}
