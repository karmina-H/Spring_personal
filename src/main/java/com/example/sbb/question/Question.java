package com.example.sbb.question;

import com.example.sbb.answer.Answer;
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;//이거 왜 자동으로 추가 안되나요?

import lombok.Setter;
import lombok.Getter;

@Entity
@Getter
@Setter//왜 여기서 Getter와 Setter를 넣어주는가? 없어도 오류 x

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "Text")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
//참조 엔티티의 속성명은 무엇을 의미하는가? ->"mappedBy = "question"