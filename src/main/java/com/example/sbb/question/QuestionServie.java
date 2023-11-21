package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServie {
    private final QuestionRepository questionRepository;

    public List<Question> getlist(){
        return this.questionRepository.findAll();
    }
}
