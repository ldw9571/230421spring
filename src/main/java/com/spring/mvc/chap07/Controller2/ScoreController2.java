package com.spring.mvc.chap07.Controller2;

import com.spring.mvc.chap04.service.ScoreService;
import com.spring.mvc.chap07.dto2.ScoreListResponseDTO2;
import com.spring.mvc.chap07.service2.ScoreService2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller @RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController2 {
    private final ScoreService2 scoreService2;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(defaultValue = "num")String sort){

        List<ScoreListResponseDTO2> responseDTO2List
                = scoreService2.getList(sort);

        model.addAttribute("sList",responseDTO2List);
        return "chap04/score-list";
    }


}
