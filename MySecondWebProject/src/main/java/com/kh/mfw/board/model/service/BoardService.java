package com.kh.mfw.board.model.service;

import com.kh.mfw.board.model.dao.BoardDAO;
import com.kh.mfw.board.model.dto.BoardDTO;
import static com.kh.mfw.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class BoardService {

		private BoardDAO boardDao = new BoardDAO();
		
		public void insertBoard(BoardDTO board) {
			
			SqlSession sqlSession = getSqlSession();
			
			boardDao.insertBoard(sqlSession,board);
			
			sqlSession.commit();
			sqlSession.close();
	
			
		}
		
		public Map<String, Object> selectBoards(int page){
			
			SqlSession sqlSession = getSqlSession();
			
			// Table에서 조회해온 게시글 총 개수
			int boardCount = boardDao.selectBoardCount(sqlSession);
			
			

			
			// startBtn : 페이지 하단에 보여질 버튼 중 시작 값
			// page  한 페이지에 몇 개의 페이지 버튼을 보일 것인지
			/*
			 * 한 페이지에 보여질 개수 : 5
			 * start : 1,6,11,16... 5n+1
			 * 
			 * 한 페이지에 보여질 개수 : 3
			 * start : 1,4,7,11... 3n+1
			 * 
			 * StartBtn = n *한페이지개수 +1
			 * 
			 * 한페이지에보여지는게 5개일 때
			 * 현재 page     start
			 * 1            1
			 * 5		    1
			 * 6		    5
			 * 10		    6
			 * 14		    11	
			 * 
			 * => 1~5  : n*5+1 ==> n==0
			 * => 6~10 : n*5+1 ==> n==1
			 * 
			 * (page-1)/5 == n
			 * 
			 * StartBtn = (현재 page - 1)/5 * 5 + 1
			 * 
			 */
			// 마지막 페이지를 구해야 함!
			// 한 페이지에 보여줄 게시글 개수 : 10개
			int boardLimit = 10; // 한페이지에 보여질 게시글 개수
			int maxPage = (boardCount+9)/boardLimit;
			
			int btnLimit =5; // 한페이지에 보여줄 버튼 개수
			int startBtn = (page-1)/btnLimit*btnLimit+1;
			
			int endBtn = startBtn+btnLimit-1;
			
			if(endBtn>maxPage) endBtn = maxPage;
			
			/*
			 * MyBatis에서 제공하는 RowBounds객체
			 * 
			 * offset과 limit을 생성자 매개변수로 전달해주어야 함
			 * 
			 * page 1 : 1~3 => 0
			 * page 2 : 4~6 => 3
			 * page 3 : 7~9 => 6
			 * 
			 * (page-1) * boardLimit
			 */
			RowBounds rowBounds = new RowBounds((page-1) * boardLimit,boardLimit);
			
			// page == 앞단에서 넘어온 요청 페이지
			List<BoardDTO> boards = boardDao.selectBoards(sqlSession,rowBounds);
						
			System.out.println(boards);
			sqlSession.close();
			
			Map<String, Object> map = new HashMap();
			map.put("boards",boards);
			map.put("boardCount",boardCount);
			map.put("page",page);
			map.put("boardLimit",boardLimit);
			map.put("btnLimit",btnLimit);
			map.put("maxPage",maxPage);
			map.put("startBtn",startBtn);
			map.put("endBtn",endBtn);
			
			return map;
		}
		
		
		public BoardDTO findByBoardNo(int boardNo) {
			SqlSession sqlSession = getSqlSession();
			
			// 최대 두번 가야함
			// 조회수 증가 로직 한 번     ==> update/commit
			// 게시글 정보 조회 로직 한 번 ==> select
			
			int updateResult = boardDao.increaseCount(sqlSession, boardNo);
			if(updateResult==0) {
				sqlSession.close();
				return null;
			}
			// count가 0보다 크면 게시글이 있다는 거니까 정보 조회하러 감
			BoardDTO board = boardDao.findByBoardNo(sqlSession,boardNo);
			
			if(board != null) {
				sqlSession.commit();
			}
			sqlSession.close();
			return board;
		}
}
