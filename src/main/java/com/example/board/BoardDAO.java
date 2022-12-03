package com.example.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
//	Connection conn = null;
//	PreparedStatement stmt = null;
//	ResultSet rs = null;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final String BOARD_INSERT = "insert into BOARD (title, writer, content, category) values (?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo){
		String sql = "insert into BOARD (title,writer,content,category) values(" + "'" + vo.getTitle() + "'," + "'" + vo.getWriter() + "'," +"'"+vo.getContent()+"',"+"'"+vo.getCategory()+"')";
		return jdbcTemplate.update(sql);
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq = "+seq;
		return jdbcTemplate.update(sql);
	}
	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set title= '"+ vo.getTitle() +"',"
				+"writer='"+vo.getWriter()+"',"
				+"content='"+vo.getContent()+"',"
				+"category='"+vo.getCategory()+"' where seq="+ vo.getSeq();
		return jdbcTemplate.update(sql);
	}
	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq="+ seq;
		return jdbcTemplate.queryForObject(sql,new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(){
		String sql= "select * from BOARD order by regdate desc";
		return jdbcTemplate.query(sql,new BoardRowMapper());
	}
}
