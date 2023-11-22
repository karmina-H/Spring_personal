package com.example.sbb.answer;

import com.example.sbb.question.QuestionServie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.example.sbb.question.Question;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionServie questionServie;
    public final AnswerService answerService;

    @PostMapping("/create/{id}")
        public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        Question question = this.questionServie.getQuestion(id);
        this.answerService.create(question,content);
        return String.format("redirect:/question/detail/%s",id);
        }
}
