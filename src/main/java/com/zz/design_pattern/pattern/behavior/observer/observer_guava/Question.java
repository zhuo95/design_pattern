package com.zz.design_pattern.pattern.behavior.observer.observer_guava;

public class Question {
    private String question;
    private String userName;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question(String question, String userName) {
        this.question = question;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
