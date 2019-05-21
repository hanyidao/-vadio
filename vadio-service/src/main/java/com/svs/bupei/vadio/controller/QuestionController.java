package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.Question;
import com.svs.bupei.vadio.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/selectAllQuestion")
    public Map<String,Object> selectAllQuestion(Question question)
    {
        return questionService.selectAllQuestion(question);
    }

    @PostMapping("/insertQuestion")
    public Map<String,Object> insertQuestion(Question question)
    {
        return questionService.insertQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{qid}")
    public Map<String,Object> deleteQuestion(@PathVariable("qid") int qid)
    {
        return questionService.deleteQuestion(qid);
    }

    @PostMapping("/updateQuestion")
    public Map<String,Object> updateQuestion(Question question)
    {
        return questionService.updateQuestion(question);
    }

}
