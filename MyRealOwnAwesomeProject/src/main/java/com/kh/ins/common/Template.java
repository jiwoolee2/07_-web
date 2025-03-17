package com.kh.ins.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {



	public static SqlSession getSqlSession() {
		
		 SqlSession sqlSession = null;
		 
		 try {
			 InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml"); // inputStream 반환
		
			 sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
		
			 
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return sqlSession;
	}
	
	
	
	
	
	
}

