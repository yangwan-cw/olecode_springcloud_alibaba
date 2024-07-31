package com.ioomex.codeJuge.app.judge.controller;

import com.ioomex.codeJuge.app.judge.JudgeService;
import com.ioomex.module.app.entity.QuestionSubmit;
import com.ioomex.service.client.service.JudgeFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/inner")
public class QuestioninnerController implements JudgeFeign {

    @Resource
    private JudgeService judgeService;


    @Override
    @GetMapping("/do")
    public QuestionSubmit doJudge(long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }
}
