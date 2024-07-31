package com.ioomex.service.client.service;


import com.ioomex.module.app.entity.Question;
import com.ioomex.module.app.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "olecode_question_service", path = "/api/question/inner")
public interface QuestionFeign {

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question submit/get/id")
    Question getQvestionSubmitById(@RequestParam("guestionId") long questionSubmitId);

    @PostMapping("/question _submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

}
