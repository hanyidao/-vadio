package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.Buy;
import com.svs.bupei.vadio.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    BuyService buyService;
    /**
     * 查询买家订单 管理专用
     */
    @PostMapping("/show")
    public Map<String,Object> showListPage( Buy buy){
        System.out.println("d1");
        return buyService.showListPage(buy);
    }


    /**
     * 修改功能
     */
    @PostMapping("/update")
    public  Map<String, Object> update( Buy buy) {
        System.out.println("du");
        return buyService.updateBuy(buy);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{bid}")
    public String delete(@PathVariable("bid") String bid) {
        System.out.println("db");
        return  buyService.deleteBuy(bid);
    }

    /**
     * 添加功能
     * 成功返回总价钱
     * 失败返回添加失败
     */
    @PostMapping("/save")
    public Map<String, Object>  save(Buy buy) {
        System.out.println("ds");
        return buyService.addBuy(buy);
    }

    /**
     *
     *
     */
    @PostMapping("/updatemoney")
    public Map<String, Object>  updateMoney(Buy buy) {
        return buyService.updateMoney(buy);
    }
    /**
     *
     * 当卖出货物时Depot库存减少
     */
    @PostMapping("/updatednum")
    public int updateDepotbnum(Buy buy) {
         return buyService.updateDepotbnum(buy);
    }
}