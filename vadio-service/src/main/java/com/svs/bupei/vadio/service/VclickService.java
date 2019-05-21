package com.svs.bupei.vadio.service;

import com.svs.bupei.Constants;
import com.svs.bupei.vadio.mapper.VclickMapper;
import com.svs.bupei.vadio.pojo.Vclick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VclickService {

    @Autowired
    private VclickMapper vclickMapper;

    /**
     * 查询所有vclick表数据
     * @param vclick
     * @return 所有数据
     */
    public Map<String,Object> selectAllVclick(Vclick vclick)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("data",vclickMapper.selectAllVclick(vclick));
        map.put("count", vclickMapper.selectCountVclick(vclick));
        return map;
    }

    /**
     * 插入一条数据
     * @param vclick
     * @return
     */
    public Map<String,Object> insertVclick(Vclick vclick)
    {
        Map<String,Object> map = new HashMap<>();
        int i = vclickMapper.insertVclick(vclick);
        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_INSERT);
        }else
        {
            map.put("msg",Constants.ERROR_INSERT);
        }
        return map;
    }

}
