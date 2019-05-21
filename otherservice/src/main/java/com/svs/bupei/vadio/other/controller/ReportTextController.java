package com.svs.bupei.vadio.other.controller;


import com.svs.bupei.vadio.other.pojo.ReportText;
import com.svs.bupei.vadio.other.service.ReportTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reporttext")
public class ReportTextController {

    @Autowired
    ReportTextService reportTextService;

    @PostMapping("/selectAllReportText")
    public Map<String,Object> selectAllReportText(ReportText reportText)
    {
        return reportTextService.selectAllReportText(reportText);
    }

    @PostMapping("/insertReportText")
    public Map<String,Object> insertReportText(ReportText reportText)
    {
        return reportTextService.insertReportText(reportText);
    }

    @DeleteMapping("/deleteReportText/{reid}")
    public Map<String,Object> deleteReportText(@PathVariable("reid") int reid)
    {
        return reportTextService.deleteReportText(reid);
    }

    @PostMapping("/managerUpdateReportText")
    public Map<String,Object> managerUpdateReportText(ReportText reportText){
        return reportTextService.managerUpdateReportText(reportText);
    }

}
