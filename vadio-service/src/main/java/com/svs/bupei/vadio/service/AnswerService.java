package com.svs.bupei.vadio.service;

import com.svs.bupei.Constants;
import com.svs.bupei.vadio.mapper.AnswerMapper;
import com.svs.bupei.vadio.pojo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnswerService {

    @Autowired
    AnswerMapper answerMapper;

    /**
     * 模糊查询返回所有数据以及数据总个数
     * @param answer
     * @return
     */
    public Map<String,Object> selectAllAnswer(Answer answer)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("data", answerMapper.selectAllAnswer(answer));
        map.put("count", answerMapper.selectCountAnswer(answer));
        return map;
    }

    /**
     * 添加一条信息
     * @param answer
     * @return 添加结果字符串
     */
    public Map<String,Object> insertAnswer(Answer answer)
    {
        Map<String,Object> map = new HashMap<>();

        int i = answerMapper.insertAnswer(answer);
        if(i > 0)
        {
            map.put("msg",Constants.SUCCESS_INSERT);
        }else
        {
            map.put("msg",Constants.ERROR_INSERT);
        }

        return map;
    }

    /**
     * 删除一条数据
     * @param aid
     * @return
     */
    public Map<String,Object> deleteAnswer(int aid)
    {
        Map<String,Object> map = new HashMap<>();

        int i = answerMapper.deleteAnswer(aid);
        if(i > 0)
        {
            map.put("msg",Constants.SUCCESS_DELETE);
        }else
        {
            map.put("msg",Constants.ERROR_DELETE);
        }

        return map;
    }

    /**
     * 修改一条数据
     * @param answer
     * @return
     */
    public Map<String,Object> updateAnswer(Answer answer)
    {
        Map<String,Object> map = new HashMap<>();

        int i = answerMapper.updateAnswer(answer);
        if(i > 0)
        {
            map.put("msg",Constants.SUCCESS_UPDATE);
        }else
        {
            map.put("msg",Constants.ERROR_UPDATE);
        }

        return map;
    }

}
