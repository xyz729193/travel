package com.example.travel.mapper;

import com.example.travel.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}