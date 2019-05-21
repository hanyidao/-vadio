package com.svs.bupei.vadio.service;

import com.svs.bupei.MaFactory;
import com.svs.bupei.vadio.mapper.BuyMapper;
import com.svs.bupei.vadio.pojo.Buy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BuyService {
    @Autowired
    BuyMapper buymapper;

    public Map<String, Object>  addBuy(Buy buy){
        Map<String,Object> map = new HashMap<>();
        int i = buymapper.addBuy(buy);
        if(i>0){
            map.put("msg", "添加成功！ 总价钱dan："+buy.getBmoney());
            buymapper.updateMoney(buy);
        }else{
            map.put("msg", "添加失败");
        }
        return map;
    }

    public int updateDepotbnum(Buy buy){
        return buymapper.updateDepotbnum(buy);

    }

    public String deleteBuy(String bid){
        String flage="";
        int i = buymapper.deleteBuy(bid);
        if(i>0){
            flage=("删除成功");
        }else{
            flage=("删除失败");
        }
        return flage;
    }

    public  Map<String, Object> updateBuy(Buy buy){
        Map<String,Object> map = new HashMap<>();
        int i = buymapper.updateBuy(buy);
        if(i>0){
            map.put("msg", "修改成功");
        }else{
            map.put("msg", "修改失败");
        }
        return map;
    }

    public Map<String, Object> showListPage(Buy buy) {
        Map<String, Object> map = MaFactory.createLayuiSelectMap(buymapper.showListPage(buy), "ok", buymapper.showListPageCount(buy));
        System.out.println(buymapper.showListPage(buy));
        return map;
    }

    public Map<String, Object> updateMoney(Buy buy) {
        Map<String,Object> map = new HashMap<>();
        int i = buymapper.updateMoney(buy);
        if(i>0){
            map.put("msg", i);
        }else{
            map.put("msg", "修改失败");
        }
        return map;
    }


}