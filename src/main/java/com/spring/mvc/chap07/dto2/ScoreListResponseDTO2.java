package com.spring.mvc.chap07.dto2;

import com.spring.mvc.chap07.entity2.Grade2;
import com.spring.mvc.chap07.entity2.Score2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter @Getter @EqualsAndHashCode
public class ScoreListResponseDTO2 {

    private final int stuNum;
    private final String maskingName;
    private final double average;
    private final Grade2 grade;

    public ScoreListResponseDTO2(Score2 s) {  //Score2 를 넣는 이유? 생성자가 있는것도 아닌데
        this.stuNum = s.getStuNum();   //여긴 또 왜 get?
        this.maskingName = makeMaskingName(s.getName());
        this.average = s.getAverage();
        this.grade = s.getGrade2();
    }

    private String makeMaskingName(String originalName) {
        String maskingName = String.valueOf(originalName.charAt(0));
        for(int i =1; i<originalName.length(); i++){
            maskingName += "*";
        }
        return maskingName;

    }
}
