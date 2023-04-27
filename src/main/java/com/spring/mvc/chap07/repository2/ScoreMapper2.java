package com.spring.mvc.chap07.repository2;

import com.spring.mvc.chap07.entity2.Score2;

import java.util.List;

public interface ScoreMapper2 {

    List<Score2> findAll(String sort);

    boolean save(Score2 score);

    boolean deleteByStuNum(int stuNum);

    Score2 findByStuNum(int stuNum);

}
