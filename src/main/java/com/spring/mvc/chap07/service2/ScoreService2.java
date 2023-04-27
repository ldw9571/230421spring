package com.spring.mvc.chap07.service2;

import com.spring.mvc.chap04.dto.ScoreListResponseDTO;
import com.spring.mvc.chap07.dto2.ScoreListResponseDTO2;
import com.spring.mvc.chap07.repository2.ScoreMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service  //빈 객체를 생성해준다는 뜻이 무슨 뜻
public class ScoreService2 {

    private final ScoreMapper2 scoremapper2;

    @Autowired

    public ScoreService2(ScoreMapper2 scoremapper2) {   //이건 뭐임?
        this.scoremapper2 = scoremapper2;
    }

    public List<ScoreListResponseDTO2> getList(String sort){

        return scoremapper2.findAll(sort)
                .stream()
                .map(ScoreListResponseDTO2::new)
                .collect(Collectors.toList());  //?????????

    }







}
