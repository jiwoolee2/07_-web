package com.kh.mfw.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	
	/* JDBC Util에서는
	 * 
	 * public Connection getConnection() {
	 * 	
	 * 	머시기머시기
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	/* MyBatis 버전 */
	
	// SqlSession을 반환받는 메서드
	public static SqlSession getSqlSession() {
		
		 SqlSession sqlSession = null;
		 
		 try {
			 InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml"); // inputStream 반환
			
			 // 1단계 : SqlSessionFactoryBuilder 객체 생성
			 //		그냥 생성자 호출하면 됨
			 // 2단계 : SqlSessionFactory 객체 생성
			 //		build(입력스트림) 스트림으로부터 환경설정파일의 값을 읽어오면서 SqlSessionFactory객체 생성
			 // 3단계 : SqlSession 객체 생성 --> Connection의 역할 대체
			 sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			 // -> Service에서 호출
			 
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return sqlSession;
	}
	
	
	
	
	
	
}
