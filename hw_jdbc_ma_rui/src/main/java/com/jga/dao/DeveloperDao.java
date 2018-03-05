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

public class DeveloperDao {
	public static DeveloperDao instance=null;
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance=new DeveloperDao();
		}
		return instance;
	}
	private DeveloperDao() {}
	
	
	public List<Developer> findAllDevelopers() {
		List<Developer> developers = new ArrayList<>();
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Developer INNER JOIN Person ON Person.id=Developer.id";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String developerKey = rs.getString("developerKey");
	          String firstName = rs.getString("firstName");
	          String lastName = rs.getString("lastName");
	          String username = rs.getString("username");
	          String password = rs.getString("password");
	          String email = rs.getString("email");
	          Developer developer = new Developer(id,developerKey,firstName, lastName, username, password, email, null);
	          developers.add(developer);
		    }
	    
	    rs.close();
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
	return developers;
	}
	
	public Developer findDeveloperById(int i) {

		Developer developer = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Developer INNER JOIN Person ON Person.id=Developer.id WHERE Developer.id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String developerKey = rs.getString("developerKey");
	          String firstName = rs.getString("firstName");
	          String lastName = rs.getString("lastName");
	          String username = rs.getString("username");
	          String password = rs.getString("password");
	          String email = rs.getString("email");
	          developer = new Developer(id,developerKey,firstName, lastName, username, password, email, null);
		    }
	    
	    rs.close();
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
	return developer;
	}
	
	public Developer findDeveloperByUserName(String u) {
		Developer developer = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Developer INNER JOIN Person ON Person.id=Developer.id WHERE username=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, u);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String developerKey = rs.getString("developerKey");
	          String firstName = rs.getString("firstName");
	          String lastName = rs.getString("lastName");
	          String username = rs.getString("username");
	          String password = rs.getString("password");
	          String email = rs.getString("email");
	          developer = new Developer(id,developerKey,firstName, lastName, username, password, email, null);
		    }
	    
	    rs.close();
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
	return developer;
	}
	
	public Developer findDeveloperByCredentials(String u, String p) {
		Developer developer = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Developer INNER JOIN Person ON Person.id=Developer.id WHERE username=? && password=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, u);
		stmt.setString(2, p);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String developerKey = rs.getString("developerKey");
	          String firstName = rs.getString("firstName");
	          String lastName = rs.getString("lastName");
	          String username = rs.getString("username");
	          String password = rs.getString("password");
	          String email = rs.getString("email");
	          developer = new Developer(id,developerKey,firstName, lastName, username, password, email, null);
		    }
	    
	    rs.close();
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
	return developer;
	}	
			
	public void createDeveloper(Developer developer) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "INSERT INTO Person (id,firstName,lastName,username,password,email,dob) VALUES (?,?,?,?,?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developer.getId());
		stmt.setString(2, developer.getFirstName());
		stmt.setString(3, developer.getLastName());
		stmt.setString(4, developer.getUsername());
		stmt.setString(5, developer.getPassword());
		stmt.setString(6, developer.getEmail());
		stmt.setDate(7, (Date) developer.getDob());
		stmt.executeUpdate();
		
		sql = "INSERT INTO Developer (id,developerKey) VALUES (?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developer.getId());
		stmt.setString(2, developer.getDeveloperKey());
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
	
	
	public void deleteDeveloper(int i) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "DELETE FROM Person WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		stmt.executeUpdate();		
		
		sql = "DELETE FROM Developer WHERE id=?";
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
	public void updateDeveloper(int i, Developer developer) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "UPDATE Person SET id=?,firstName = ?,lastName = ?,username = ?,password = ?,email = ?,dob = ? WHERE id= ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developer.getId());
		stmt.setString(2, developer.getFirstName());
		stmt.setString(3, developer.getLastName());
		stmt.setString(4, developer.getUsername());
		stmt.setString(5, developer.getPassword());
		stmt.setString(6, developer.getEmail());
		stmt.setDate(7, (Date) developer.getDob());
		stmt.setInt(8, i);
		stmt.executeUpdate();
		
		sql = "UPDATE Developer SET id= ?, developerKey=? WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developer.getId());
		stmt.setString(2, developer.getDeveloperKey());
		stmt.setInt(3, i);
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
