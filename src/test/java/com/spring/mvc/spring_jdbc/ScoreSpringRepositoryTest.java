package com.spring.mvc.spring_jdbc;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ScoreSpringRepositoryTest {

    @Autowired
    ScoreSpringRepository scoreSpringRepository;

    @Test
    void saveScoreTest(){
    Score s = new Score();

        s.setName("이동우");
        s.setKor(78);
        s.setEng(75);
        s.setMath(46);
        s.setTotal(s.getKor()+s.getMath()+s.getEng());

        scoreSpringRepository.saveScore(s);
    }
    @Test
    void modifyScore(){
        Score s = new Score();
        s.setKor(100);
        s.setEng(100);
        s.setMath(99);
        s.setStuNum(2);

        boolean flag = scoreSpringRepository.modifyScore(s);
        assertTrue(flag);
    }

};


