package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.simplilearn.config.ConnectionProvider;
import com.simplilearn.model.User;

public class RegisterDao {
	public static int register(User u){  
		int status=0;  
		try{  
		Connection con=ConnectionProvider.getCon();  
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?)");  
		ps.setString(1,u.getUname());  
		ps.setString(2,u.getUemail());  
		ps.setString(3,u.getUpass());  
		              
		status=ps.executeUpdate(); 
			
		}catch(Exception e){}  
		      
		return status;  
		}  
}
