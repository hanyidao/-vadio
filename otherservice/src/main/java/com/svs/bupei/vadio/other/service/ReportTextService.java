package com.svs.bupei.vadio.other.service;

import com.svs.bupei.vadio.other.mapper.ReportTextMapper;
import com.svs.bupei.Constants;
import com.svs.bupei.vadio.other.pojo.ReportText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportTextService {

    @Autowired
    ReportTextMapper reportTextMapper;

    /**
     * 按用户与resuccess模糊查询所有数据
     * @param reportText
     * @return
     */
    public Map<String,Object> selectAllReportText(ReportText reportText)
    {
        Map<String,Object> map = new HashMap<>();

        map.put("data", reportTextMapper.selectAllReportText(reportText));
        map.put("count",reportTextMapper.selectCountReportText(reportText));

        return map;
    }

    /**
     * 插入一条举报评论数据
     * @param reportText
     * @return
     */
    public Map<String,Object> insertReportText(ReportText reportText)
    {
        Map<String,Object> map = new HashMap<>();

        int i = reportTextMapper.insertReportText(reportText);
        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_INSERT);
        }else
        {
            map.put("msg",Constants.ERROR_INSERT);
        }

        return map;
    }

    /**
     * 删除一条举报评论信息
     * @param reid
     * @return
     */
    public Map<String,Object> deleteReportText(int reid)
    {
        Map<String,Object> map = new HashMap<>();

        int i = reportTextMapper.deleteReportText(reid);
        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_DELETE);
        }else
        {
            map.put("msg",Constants.ERROR_DELETE);
        }

        return map;
    }

    public Map<String,Object> managerUpdateReportText(ReportText reportText)
    {
        Map<String,Object> map = new HashMap<>();



        if(reportText.getResuccess().equals("已同意"))
        {
            int i = reportTextMapper.updateReportTextQuestion(reportText.getReid());
            if(i <= 0)
            {
                map.put("msg",Constants.NOTHING_VADIO);
                return map;
            }
        }

        if(reportText.getResuccess().equals("已同意") || reportText.getResuccess().equals("未同意"))
        {
            int i = reportTextMapper.managerUpdateReportText(reportText);
            if(i > 0)
            {
                map.put("msg",Constants.SUCCESS_UPDATE);
            }else {
                map.put("msg",Constants.ERROR_UPDATE);
            }
        }else
        {
            map.put("msg",Constants.ERROR_RSUCCESS);
        }



        return map;
    }

}
