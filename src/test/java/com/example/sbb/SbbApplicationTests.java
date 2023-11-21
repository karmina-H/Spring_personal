package com.example.sbb;

import com.example.sbb.answer.Answer;
import com.example.sbb.answer.AnswerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    // contextLoads
    @Test
    @Transactional
    void testJpa() {
        Optional<Question> oq =this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1,answerList.size());
        assertEquals("네 자동으로 생성됩니다", answerList.get(0).getContent());

    }

}
