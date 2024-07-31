package com.ioomex.question.app.controller.inner;


import com.ioomex.module.app.entity.Question;
import com.ioomex.module.app.entity.QuestionSubmit;
import com.ioomex.question.app.service.QuestionService;
import com.ioomex.question.app.service.QuestionSubmitService;
import com.ioomex.service.client.service.QuestionFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/inner")
public class QuestioninnerController implements QuestionFeign {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;


    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(long questionId) {
        return questionService.getById(questionId);
    }

    @Override
    @GetMapping("/questionsubmit/get/id")

    public QuestionSubmit getQvestionSubmitById(long questionSubmitId) {
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }
}
