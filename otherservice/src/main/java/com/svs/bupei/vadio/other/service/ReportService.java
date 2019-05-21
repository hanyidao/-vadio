package com.svs.bupei.vadio.other.service;

import com.svs.bupei.vadio.other.mapper.ReportMapper;
import com.svs.bupei.Constants;
import com.svs.bupei.vadio.other.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    ReportMapper reportMapper;

    /**
     * 按用户或视频模糊查询所有未被封禁的评论
     * @param report
     * @return
     */
    public Map<String,Object> selectAllReport(Report report)
    {
        Map<String,Object> map = new HashMap<>();

        map.put("data" , reportMapper.selectAllReport(report));
        map.put("count", reportMapper.selectCountReport(report));

        return map;
    }

    /**
     * 插入一条举报数据
     * @param report
     * @return
     */
    public Map<String,Object> insertReport(Report report)
    {
        Map<String,Object> map = new HashMap<>();

        int i = reportMapper.insertReport(report);
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
     * 删除一条举报信息
     * @param rid
     * @return
     */
    public Map<String,Object> deleteReport(int rid)
    {
        Map<String,Object> map = new HashMap<>();

        int i = reportMapper.deleteReport(rid);
        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_DELETE);
        }else
        {
            map.put("msg",Constants.ERROR_DELETE);
        }

        return map;
    }

    /**
     * 管理员同意一条举报信息
     * @param report
     * @return
     */
    public Map<String,Object> managerReportReport(Report report)
    {
        Map<String,Object> map = new HashMap<>();


        if(report.getRsuccess().equals("已同意"))
        {
            int i = reportMapper.updateReportVadio(report.getRid());
            if(i <= 0)
            {
                map.put("msg",Constants.NOTHING_VADIO);
                return map;
            }
        }

        if(report.getRsuccess().equals("已同意") || report.getRsuccess().equals("未同意"))
        {
            int i = reportMapper.managerUpdateReport(report);
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
