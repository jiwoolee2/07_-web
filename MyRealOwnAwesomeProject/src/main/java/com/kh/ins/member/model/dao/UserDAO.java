package com.kh.ins.member.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;
import org.apache.ibatis.session.SqlSession;

import com.kh.ins.member.model.dto.UserDTO;

public class UserDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public UserDTO login(SqlSession sqlSession, UserDTO user) {
		
		
		
		return sqlSession.selectOne("userMapper",user);
		
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











































