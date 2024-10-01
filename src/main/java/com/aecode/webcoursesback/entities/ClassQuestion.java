package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classquestion")
public class ClassQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @ManyToOne
    @JoinColumn(name = "classId", nullable = false)
    private Class classes;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionText;



    public ClassQuestion() {
    }

    public ClassQuestion(int questionId, Class classes, String questionText) {
        this.questionId = questionId;
        this.classes = classes;
        this.questionText = questionText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }


}
