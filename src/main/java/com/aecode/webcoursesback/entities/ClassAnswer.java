package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "classanswer")
public class ClassAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private ClassQuestion classquestion;

    @Column(nullable = false, length = 255)
    private String answerText;

    @Column(nullable = false)
    private boolean isCorrect;

    public ClassAnswer() {
    }

    public ClassAnswer(int answerId, ClassQuestion classquestion, String answerText, boolean isCorrect) {
        this.answerId = answerId;
        this.classquestion = classquestion;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public ClassQuestion getClassquestion() {
        return classquestion;
    }

    public void setClassquestion(ClassQuestion classquestion) {
        this.classquestion = classquestion;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
