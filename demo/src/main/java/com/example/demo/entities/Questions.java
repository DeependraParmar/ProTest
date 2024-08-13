package com.example.demo.entities;

import com.example.demo.models.QuestionModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "option1", nullable = false)
    private String option1;

    @Column(name = "option2", nullable = false)
    private String option2;

    @Column(name = "option3", nullable = false)
    private String option3;

    @Column(name = "option4", nullable = false)
    private String option4;

    @Column(name = "correct_answer", nullable = false)
    private Integer answer;

    @ManyToOne
    @JoinColumn(name = "test")
    private Test test;


    public Questions(QuestionModel object) {
        this.question = object.getQuestion();
        this.option1 = object.getOption1();
        this.option2 = object.getOption2();
        this.option3 = object.getOption3();
        this.option4 = object.getOption4();
        this.answer = object.getAnswer();
    }
}
