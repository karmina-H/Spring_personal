package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionServie questionServie;

    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionServie.getlist();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
