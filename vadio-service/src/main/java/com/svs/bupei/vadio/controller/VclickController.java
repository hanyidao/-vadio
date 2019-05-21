package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.Vclick;
import com.svs.bupei.vadio.service.VclickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/vclick")
public class VclickController {

    @Autowired
    private VclickService vclickService;

    @PostMapping("/selectAllVclick")
    public Map<String,Object> selectAllVclick(Vclick vclick)
    {
        return vclickService.selectAllVclick(vclick);
    }

    @PostMapping("/insertVclick")
    public Map<String,Object> insertVclick(Vclick vclick)
    {
        return vclickService.insertVclick(vclick);
    }

}
