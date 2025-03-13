package com.kh.mfw.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public MemberDTO login(MemberDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = """
					SELECT
					     	MEMBER_ID,
							MEMBER_PW,
							MEMBER_NAME,
							EMAIL,
							ENROLL_DATE
					FROM
							KH_MEMBER
					WHERE
							MEMBER_ID = ?
					AND	
							MEMBER_PW = ?
				""";
	    MemberDTO loginMember = null;
		
		try {
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@112.221.156.34:12345:XE",
					"KH18_LJW","KH1234");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new MemberDTO(rset.getString("Member_ID"),
											rset.getString("MEMBER_PW"),
											rset.getString("MEMBER_NAME"),
											rset.getString("EMAIL"),
											rset.getDate("ENROLL_DATE"));
			}
		
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if( rset != null) rset.close();
				if( pstmt!= null) rset.close();
				if( conn != null) rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return loginMember;
		
	}
	
	
	
	
	public int checkId(String memberId) {
		
		String sql = """
						SELECT
							   COUNT(*)	
						  FROM
						   	   KH_MEMBER
						WHERE
							   MEMBER_ID = ?
					""";
		
		ResultSet rset = null;
		int result = 0;
		
		try (
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@112.221.156.34:12345:XE",
					"KH18_LJW", "KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql)
			){
			
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			/* case 1 : SELECT문을 COUNT(*)로 작성했을 때 무조건 ResultSet이 1행이 존재,
			 * 		    컬럼값이 0이냐 1이냐로 조회결과 판별
			 * 
			 * rset.next();
			 * return rset.getInt("COUNT(*)")
			 * 
			 */
			
			/* case 2 : MEMBER_ID 컬럼을 조회한 경우
			 * 
			 * rset.getString("MEMBER_ID")
			 * 
			 * 
			 * 
			 */
			rset.next();
			result = rset.getInt("COUNT(*)");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) rset.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		} return result;
	}
	
	
	
	
	
	public void signUp(MemberDTO member) {
		
		String sql = """
						INSERT INTO KH_MEMBER VALUES
						(?,?,?,?,DEFAULT)
				""";
		
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@112.221.156.34:12345:XE",
					"KH18_LJW",
					"KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql)
					
	
			){
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getEmail());
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	public void modify(MemberDTO member) {
		
		String sql = """
						UPDATE 
							KH_MEMBER 
						SET
							MEMBER_NAME = ?,
							EMAIL = ?
						WHERE
							MEMBER_ID = ?
					""";

		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@112.221.156.34:12345:XE",
					"KH18_LJW", "KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getEmail());			
			pstmt.setString(3, member.getMemberId());
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public int newPassword(String memberId, String changePw, String userPw) {
		
		String sql = """
						UPDATE
								KH_MEMBER
						   SET
								MEMBER_PW = ?
						 WHERE
								MEMBER_ID = ?
						   AND
								MEMBER_PW = ?
					""";
		int result = 0;
		
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@112.221.156.34:12345:XE",
					"KH18_LJW",
					"KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
		){
			pstmt.setString(1, changePw);
			pstmt.setString(2, memberId);
			pstmt.setString(3, userPw);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return result;
	}
	
	
	
	
	public int quit(String memberId) {
		
		String sql = """ 
						DELETE
						  FROM KH_MEMBER
					     WHERE 
					     	   MEMBER_ID = ?
					""";
		
		int result = 0;
		
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@112.221.156.34:12345:XE",
				"KH18_LJW", 
				"KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
		){
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
		
		
	}
	
	
	
	
	
	
	

}








































