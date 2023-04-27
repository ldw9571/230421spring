package com.spring.mvc.chap07.entity2;

import com.spring.mvc.chap07.dto2.ScoreRequestDTO2;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score2 {

    private String name;
    private int kor;
    private int math;
    private int eng;

    private int stuNum;
    private int total;
    private double average;
    private Grade2 grade2;

    public Score2 (ScoreRequestDTO2 dto){
        this.name=dto.getName(); //왜 getname인가
        changeScore(dto); //dto 어디서 받아오는것인가
    }
//???
    public Score2(ResultSet rs)throws SQLException {    //sql연결?
        this.stuNum = rs.getInt("stu_num");
        this.name = rs.getString("stu_name");
        this.kor = rs.getInt("kor");
        this.eng = rs.getInt("eng");
        this.math = rs.getInt("math");
        this.total = rs.getInt("total");
        this.average = rs.getDouble("average");
        this.grade2 = Grade2.valueOf(rs.getString("grade"));
    }


    private void changeScore(ScoreRequestDTO2 dto) {
        this.kor=dto.getKor();   //국영수 써야해서 따로?
        this.eng=dto.getEng();    //작성할거 이름 국영수라
        this.math=dto.getMath();
        calcTotalAndAvg();
        calcGrade();
    }

    private void calcGrade() {
        if(average>=90){
            this.grade2=Grade2.A;
        }else if(average>=80){
            this.grade2= Grade2.B;
        }else if(average>=70){
            this.grade2=Grade2.C;
        }else{
            this.grade2=Grade2.F;
        }
    }

    private void calcTotalAndAvg() {
        this.total=kor+eng+math;
        this.average=total/3;
    }


}
