package com.ecobank.personalAcc.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
		
			public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
				 Connection conn = null;
			        String host = "";
			        String passwords = "";
			        String Instance = "";
			        String usernames = "";
			        ////////temp//////
			        host = "rac-eng-scan";
			        usernames = "FCUBSAWA";
			        passwords = "AWAUAT123$";
			        Instance = "FCAWAUAT";
			        
			        


			        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			        System.out.println("Connecting to the database..." + host + " : ---- : " + usernames);
			        //conn = DriverManager.getConnection(host, usernames, (passwords));
			        try {
						conn = DriverManager.getConnection(
						        "jdbc:oracle:thin:@" + host + ":1521/" + Instance + "", usernames, passwords);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println("Connected to the database");
			        return conn;
			
				
				
				
				
			}

			public static void close(Connection conn, CallableStatement cStmt, ResultSet resultSet) {
				// TODO Auto-generated method stub
				 if (conn != null) {
			            try {
			                conn.close();
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
			        if(cStmt != null){
			            try {
			                cStmt.close();
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
			        if(resultSet != null){
			            try {
			                resultSet.close();
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
				
			}
	
	
	
	
	
}
