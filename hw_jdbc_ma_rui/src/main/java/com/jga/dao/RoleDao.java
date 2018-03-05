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
import com.jga.models.Role;

public class RoleDao {
	public static RoleDao instance=null;
	public static RoleDao getInstance() {
		if(instance == null) {
			instance=new RoleDao();
		}
		return instance;
	}
	private RoleDao() {}
	
	public void assignWebsiteRole(int developerId, int websiteId, String dtype) {
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
			final String USERNAME = "marui";
			final String PASSWORD = "Aa84061776";
			Connection conn = null;
			PreparedStatement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO Role (developerId,websiteId,dtype) VALUES (?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, developerId);
			stmt.setInt(2, websiteId);
			stmt.setString(3, dtype);
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
	
	public void assignPageRole(int developerId, int pageId, String dtype) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "INSERT INTO Role (developerId,pageId,dtype) VALUES (?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developerId);
		stmt.setInt(2, pageId);
		stmt.setString(3, dtype);
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

	public void deleteWebsiteRole(int developerId, int websiteId, String dtype) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "DELETE FROM Role WHERE developerId = ? && websiteId = ? && dtype = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developerId);
		stmt.setInt(2, websiteId);
		stmt.setString(3, dtype);
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
	
	public void deletePageRole(int developerId, int pageId, String dtype) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "DELETE FROM Role WHERE developerId = ? && pageId = ? && dtype = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developerId);
		stmt.setInt(2, pageId);
		stmt.setString(3, dtype);
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
	
	
	public Role retrievePageRole(int developerId, int pageId) {
		Role role = null;
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
		String sql = "SELECT * FROM Role WHERE developerId=? AND websiteId=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, developerId);
		stmt.setInt(2, pageId);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String dtype = rs.getString("dtype");
	          role = new Role(id,developerId,(Integer) null, pageId, dtype);
		    }
		
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
	return role;
}
	
	public void deleteWebsiteRoles(int websiteId) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "DELETE * FROM Role WHERE websiteId = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, websiteId);
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
	
	public void deletePageRoles(int pageId) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "DELETE * FROM Role WHERE pageId = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, pageId);
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
