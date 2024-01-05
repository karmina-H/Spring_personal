package com.example.sbb.answer;

import com.example.sbb.question.QuestionServie;
import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import com.example.sbb.question.Question;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionServie questionServie;
    private final AnswerService answerService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
        public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
                                   Principal principal, BindingResult bindingResult){
        Question question = this.questionServie.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if(bindingResult.hasErrors())
        {
            model.addAttribute("question",question);
            return "question_detail";
        }
        this.answerService.create(question, answerForm.getContent(),siteUser);
        return String.format("redirect:/question/detail/%s",id);
        }
}
