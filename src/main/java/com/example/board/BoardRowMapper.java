package com.example.board;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
        BoardVO vo = new BoardVO();
        vo.setSeq(rs.getInt("seq"));
        vo.setTitle(rs.getString("title"));
        vo.setContent(rs.getString("content"));
        vo.setWriter(rs.getString("writer"));
        vo.setCategory(rs.getString("category"));
        vo.setRegdate(rs.getDate("regdate"));
        return vo;
    }
}
