package com.example.sbb.answer;

import com.example.sbb.question.QuestionServie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.example.sbb.question.Question;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionServie questionServie;
    public final AnswerService answerService;

    @PostMapping("/create/{id}")
        public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question = this.questionServie.getQuestion(id);
        if(bindingResult.hasErrors())
        {
            model.addAttribute("question",question);
            return "question_detail";
        }
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s",id);
        }
}
