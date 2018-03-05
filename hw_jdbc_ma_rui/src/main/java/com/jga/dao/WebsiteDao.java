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
import com.jga.models.Website;

public class WebsiteDao {
	public static WebsiteDao instance=null;
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance=new WebsiteDao();
		}
		return instance;
	}
	private WebsiteDao() {}
	
	
	public List<Website> findAllWebsites() {
		List<Website> websites = new ArrayList<>();
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
		String sql = "SELECT * FROM Website";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String name = rs.getString("name");
	          String description = rs.getString("description");
	          Date created = rs.getDate("created");
	          Date updated = rs.getDate("updated");
	          int visits = rs.getInt("visits");
	          int developerId = rs.getInt("developerId");
	          Website website = new Website(id,name,description, created, updated, visits, developerId);
	          websites.add(website);
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
	return websites;
	}
	
	public Website findWebsiteById(int i) {

		Website website = null;
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
		String sql = "SELECT * FROM Website WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String name = rs.getString("name");
	          String description = rs.getString("description");
	          Date created = rs.getDate("created");
	          Date updated = rs.getDate("updated");
	          int visits = rs.getInt("visits");
	          int developerId = rs.getInt("developerId");
	          website = new Website(id,name,description, created, updated, visits, developerId);
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
	return website;
	}
	
	public List<Website> findWebsitesForDeveloper(int i) {
		List<Website> websites = new ArrayList<>();
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
		String sql = "SELECT * FROM Website WHERE developerId=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String name = rs.getString("name");
	          String description = rs.getString("description");
	          Date created = rs.getDate("created");
	          Date updated = rs.getDate("updated");
	          int visits = rs.getInt("visits");
	          int developerId = rs.getInt("developerId");
	          Website website = new Website(id,name,description, created, updated, visits, developerId);
	          websites.add(website);
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
	return websites;
	}
	
			
	public void createWebsiteForDeveloper(int developerId, Website website) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "INSERT INTO Website(id,name,description,created,updated,visits,developerId) VALUES(?,?,?,?,?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, website.getId());
		stmt.setString(2, website.getName());
		stmt.setString(3, website.getDescription());
		stmt.setDate(4, (Date) website.getCreated());
		stmt.setDate(5, (Date) website.getUpdated());
		stmt.setInt(6, website.getVisits());
		stmt.setInt(7, developerId);
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
	
	
	public void deleteWebsite(int i) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "DELETE FROM Website WHERE id=?";
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
	public void updateWebsite(int i, Website website) {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "UPDATE Website SET id=?,name = ?,description = ?,created = ?,updated = ?,visits = ?,developerId = ? WHERE id= ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, website.getId());
		stmt.setString(2, website.getName());
		stmt.setString(3, website.getDescription());
		stmt.setDate(4, (Date) website.getCreated());
		stmt.setDate(5, (Date) website.getUpdated());
		stmt.setInt(6, website.getVisits());
		stmt.setInt(7, website.getDeveloperId());
		stmt.setInt(8, i);
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
