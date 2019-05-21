package com.svs.bupei.vadio.other.controller;

import com.svs.bupei.vadio.other.pojo.Report;
import com.svs.bupei.vadio.other.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/selectAllReport")
    public Map<String,Object> selectAllReport(Report report)
    {
        return reportService.selectAllReport(report);
    }

    @PostMapping("/insertReport")
    public Map<String,Object> insertReport(Report report)
    {
        return reportService.insertReport(report);
    }

    @DeleteMapping("/deleteReport/{rid}")
    public Map<String,Object> deleteReport(@PathVariable("rid") int rid)
    {
        return reportService.deleteReport(rid);
    }

    @PostMapping("/managerUpdateReport")
    public Map<String,Object> managerUpdateReport(Report report)
    {
        return reportService.managerReportReport(report);
    }

}
