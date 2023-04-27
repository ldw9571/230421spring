package com.spring.mvc.mybatis;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("마이바티스 매퍼로 스코어 정보 저장 성공")
    void saveTest(){

        ScoreRequestDTO s = ScoreRequestDTO.builder()
                .name("이동우")
                .kor(75)
                .math(90)
                .eng(68)
                .build();

        boolean flag = mapper.save(new Score(s));

        assertTrue(flag);
    }

    @Test
    @DisplayName("마이바티스 매퍼로 스코어 정보 삭제 성공")
    void deleteBystuNum(){
        int stuNum = 1;
        boolean flag = mapper.deleteByStuNum(1);
        assertTrue(flag);

    }

//    @Test
//    @DisplayName("마이바티스 매퍼로 스코어 전체조회 성공")
//    void findAllTest(){
//        List<Score> score = mapper.findAll();
//
//        for (Score s : score) {
//            System.out.println(s);
//        }
//        assertEquals(6, score.size());
//
//    }

    @Test
    @DisplayName("마이바티스 매퍼로 스코어 정보 개별조회 성공.")
    void findByStuNum(){
        int stuNum = 4;
        Score s = mapper.findByStuNum(stuNum);
        System.out.println("s = "+s);
        assertEquals("이동우",s.getName());
        assertEquals(12,s.getKor());
        assertEquals(12,s.getMath());
        assertEquals(12,s.getEng());
        assertEquals(36,s.getTotal());
        assertEquals(12,s.getAverage());
//        assertEquals('F',s.getGrade());

    }

}
