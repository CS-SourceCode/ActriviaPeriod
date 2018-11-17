package com.cssourcecode1819.actriviaperiod;

public class Question {
    private String question, questionType;

    public Question(String question, String questionType) {
        this.question = question;
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionType() {
        return questionType;
    }
}
