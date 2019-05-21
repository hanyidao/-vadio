package com.svs.bupei.vadio.controller;


import com.svs.bupei.vadio.pojo.Answer;
import com.svs.bupei.vadio.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/selectAllAnswer")
    public Map<String,Object> selectAllAnswer(Answer answer)
    {
        return answerService.selectAllAnswer(answer);
    }

    @PostMapping("/insertAnswer")
    public Map<String,Object> insertAnswer(Answer answer)
    {
        return answerService.insertAnswer(answer);
    }

    @DeleteMapping("/deleteAnswer/{aid}")
    public Map<String,Object> deleteAnswer(@PathVariable("aid") int aid)
    {
        return answerService.deleteAnswer(aid);
    }

    @PostMapping("/updateAnswer")
    public Map<String,Object> updateAnswer(Answer answer)
    {
        return answerService.updateAnswer(answer);
    }

}
