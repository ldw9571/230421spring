package com.spring.mvc.spring_jdbc;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScoreSpringRepository {
    private final JdbcTemplate jdbcTemplate;


    public void saveScore(Score s){
        String sql = "INSERT INTO tbl_score  " +
                "(name,kor,eng,math,total) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,s.getName(),s.getKor(),s.getEng(),s.getMath(),s.getTotal());
    }

    public boolean modifyScore(Score s){
        String sql = "UPDATE tbl_score SET kor=?,eng=?,math=? WHERE stuNum=?";

        int result = jdbcTemplate.update(sql,s.getKor(),s.getEng(),s.getMath(),s.getStuNum());
        return result ==1;

    }

}
