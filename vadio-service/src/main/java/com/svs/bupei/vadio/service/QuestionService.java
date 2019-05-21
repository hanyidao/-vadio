package com.svs.bupei.vadio.service;


import com.svs.bupei.Constants;
import com.svs.bupei.vadio.mapper.QuestionMapper;
import com.svs.bupei.vadio.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    /**
     * 模糊查询数据还有总个数
     * @param question
     * @return
     */
    public Map<String, Object> selectAllQuestion(Question question)
    {
        Map<String,Object> map = new HashMap<>();

        map.put("data",questionMapper.selectAllQuestion(question));
        map.put("count",questionMapper.selectCountQuestion(question));

        return map;
    }

    /**
     * 插入一条数据
     * @param question
     * @return
     */
    public Map<String, Object> insertQuestion(Question question)
    {
        Map<String,Object> map = new HashMap<>();

        int i = questionMapper.insertQuestion(question);

        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_INSERT);
        }else
        {
            map.put("msg", Constants.ERROR_INSERT);
        }

        return map;
    }

    /**
     * 删除一条数据
     * @param qid
     * @return
     */
    public Map<String,Object> deleteQuestion(int qid)
    {
        Map<String,Object> map = new HashMap<>();

        int i = questionMapper.deleteQuestion(qid);

        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_DELETE);
        }else
        {
            map.put("msg", Constants.ERROR_DELETE);
        }

        return map;
    }

    /**
     * 修改一条数据
     * @param question
     * @return
     */
    public Map<String,Object> updateQuestion(Question question)
    {
        Map<String,Object> map = new HashMap<>();

        int i = questionMapper.updateQuestion(question);

        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_UPDATE);
        }else
        {
            map.put("msg", Constants.ERROR_UPDATE);
        }

        return map;
    }

}
