package com.svs.bupei.vadio.service;

import com.svs.bupei.Constants;
import com.svs.bupei.vadio.mapper.GoodMapper;
import com.svs.bupei.vadio.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodService {

    @Autowired
    GoodMapper goodMapper;

    /**
     * 模糊查询数据
     * @param good
     * @return
     */
    public Map<String,Object> selectAllGood(Good good)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("data", goodMapper.selectAllGood(good));
        map.put("count", goodMapper.selectCountGood(good));
        return map;
    }

    /**
     * 添加或删除一条点赞信息
     * @param good
     * @return
     */
    public Map<String,Object> insertAndDeleteGood(Good good)
    {
        Map<String,Object> map = new HashMap<>();
        int count = goodMapper.selectCountGood(good);
        if(count > 0)
        {
            int i = goodMapper.deleteGood(good);
            if(i > 0)
            {
                map.put("msg", Constants.SUCCESS_DELETE);
            }else
            {
                map.put("msg", Constants.ERROR_DELETE);
            }
        }else
        {
            int i = goodMapper.insertGood(good);
            if(i > 0)
            {
                map.put("msg", Constants.SUCCESS_INSERT);
            }else
            {
                map.put("msg",Constants.ERROR_INSERT);
            }
        }
        return map;
    }

}
