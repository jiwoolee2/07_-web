package com.kh.ins.member.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

import com.kh.ins.member.model.dto.UserDTO;

public class UserDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public UserDTO login(UserDTO user) {
		
		String sql = """
				SELECT 
					   	*
				FROM
					   TB_USER
				WHERE
					   USER_ID = ?
				 AND
					   USER_PW = ?
				
				""";		
		
		UserDTO loginUser = new UserDTO();
		
		try (
			Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@112.221.156.34:12345:XE","KH18_LJW","KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
			
				
			){
			
			pstmt.setString(1,user.getUserId());
			pstmt.setString(2,user.getUserPw());
			ResultSet rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				loginUser.setUserNo(rset.getInt("USER_NO"));
				loginUser.setUserId(rset.getString("USER_ID"));
				loginUser.setUserPw(rset.getString("USER_PW"));
				loginUser.setUserName(rset.getString("USER_NAME"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginUser;
		
	}
	
	
	
	public void signUp(UserDTO user) {
		
		String sql = """
						INSERT INTO USER_TB VALUES
						(?,?,?,?,SYSDATE)
					""";
		
		int result = 0;
		
		try (
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@112.221.156.34:12345:XE","KH18_LJW","KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setInt(1, user.getUserNo());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserPw());
			pstmt.setString(4, user.getUserName());
			
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











































