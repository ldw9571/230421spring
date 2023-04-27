package com.spring.mvc.chap07.dto2;


import lombok.*;

@Setter @Getter
@ToString @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ScoreRequestDTO2 {

    private String name;
    private int kor,eng,math;
}
