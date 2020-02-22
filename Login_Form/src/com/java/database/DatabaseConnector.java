package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatabaseConnector{
	protected Connection conn;
	protected String connector;
	protected String sql;
	protected PreparedStatement stmt;
	public ResultSet rs;
	
	public DatabaseConnector() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connector="jdbc:mysql://localhost:3306/ProjectUserData";
			//ProjectUserData is DATABASE name
			
			conn=DriverManager.getConnection(connector,"root","");
			sql="Select * from LoginData";
			//LoginData is TABLE name
			
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery(sql);
			
			System.out.println("Successfully connected to database");
			
//			while(true) {
//				if(rs.next()) {
//					JOptionPane.showMessageDialog(null, "Login Successfull");
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Username and Password Mismatched");
//				}
//			}	
		}

		catch(Exception e) {
			System.out.print(e);
		}

		finally {
			conn.close();
		}
	}
}
