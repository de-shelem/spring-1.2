package com.khai.shelemonchak.services;

import com.khai.shelemonchak.dao.QuestionsDaoCvs;

public interface TestsServices {

    public void runTest();

    public QuestionsDaoCvs getMyQuestions();

    public void getScore();

    public QuestionsDaoCvs myQuestions = null;
    public Boolean[] myAnswers = null;
    public String name = null;

    public String getName();

    public String getSurname();

    public String surname = null;
}
