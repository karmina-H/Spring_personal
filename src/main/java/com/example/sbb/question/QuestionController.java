package com.example.sbb.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.sbb.answer.AnswerForm;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionServie questionServie;

    @GetMapping("/list")
    public String list(Model model){
        List<Question> questionList = this.questionServie.getlist();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionServie.getQuestion(id);
        model.addAttribute("question", question); //addAttribute도 타임리프인가?
        return "question_detail";
    }
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionServie.create(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
    }

}
