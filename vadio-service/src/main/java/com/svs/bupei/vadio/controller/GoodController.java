package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.Good;
import com.svs.bupei.vadio.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    GoodService goodService;

    @PostMapping("/selectAllGood")
    public Map<String,Object> selectAllGood(Good good)
    {
        return goodService.selectAllGood(good);
    }

    @PostMapping("/insertAndDeleteGood")
    public Map<String,Object> insertAndDeleteGood(Good good)
    {
        return goodService.insertAndDeleteGood(good);
    }

}
