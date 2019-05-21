package com.svs.bupei.vadio.service;

import com.svs.bupei.MaFactory;
import com.svs.bupei.vadio.mapper.DepotMapper;
import com.svs.bupei.vadio.other.Constants;
import com.svs.bupei.vadio.pojo.Depot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class DepotService {
    @Autowired
    DepotMapper depotmapper;

    public  Map<String, Object>  addDepot(Part part, Depot depot){
        Map<String,Object> map = new HashMap<>();


        String path = Constants.SAVE_PATH; //图片存储地址
        String uuid = UUID.randomUUID().toString();
        if(part != null)
        {
            String header = part.getHeaders("content-disposition").toString();
            String end = header.substring(header.lastIndexOf(".") + 1,header.length() - 2);
            if(Constants.LOGO_TYPE.indexOf(end) > -1)
            {
                try {
                    path = path + uuid + '.' + end;
                    depot.setUlogo(path);
                    part.write(path);
                    int i = depotmapper.addDepot(depot);
                    if(i > 0)
                    {
                        map.put("msg", Constants.SUCCESS_UPLOAD);
                        return map;
                    }else
                    {
                        map.put("msg", Constants.ERROR_MESSAGE_NOT_FULL);
                        return map;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    map.put("msg", Constants.ERROR_UPLOAD);
                    return map;
                }
            }else
            {
                map.put("msg", Constants.ERROR_UPLOAD_LOGO);
                return map;
            }
        }else {
            map.put("msg", Constants.ERROR_NOTHING_LOGO);
            return map;
        }
    }

    public String deleteDepot(String did){
        String flage="";
        int i = depotmapper.deleteDepot(did);
        if(i>0){
            flage=( "删除成功");
        }else{
           flage=( "删除失败");
        }
        return flage;
    }

    public Map<String, Object> updateDepot(Part part,Depot depot){
        Map<String,Object> map = new HashMap<>();
        String path = Constants.SAVE_PATH; //图片存储地址
        String uuid = UUID.randomUUID().toString();
        if(part != null)
        {
            String header = part.getHeaders("content-disposition").toString();
            String end = header.substring(header.lastIndexOf(".") + 1,header.length() - 2);
            if(Constants.LOGO_TYPE.indexOf(end) > -1)
            {
                try {
                    path = path + uuid + '.' + end;
                    depot.setUlogo(path);
                    part.write(path);
                    int i = depotmapper.updateDepot(depot);
                    if(i > 0)
                    {
                        map.put("msg", Constants.SUCCESS_UPLOAD);
                        return map;
                    }else
                    {
                        map.put("msg", Constants.ERROR_MESSAGE_NOT_FULL);
                        return map;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    map.put("msg", Constants.ERROR_UPLOAD);
                    return map;
                }
            }else
            {
                map.put("msg", Constants.ERROR_UPLOAD_LOGO);
                return map;
            }
        }else {
            map.put("msg", Constants.ERROR_NOTHING_LOGO);
            return map;
        }
    }

    public Map<String, Object> showListPage(Depot depot) {
        Map<String, Object> map = MaFactory.createLayuiSelectMap(depotmapper.showListPage(depot), "ok", depotmapper.showListPageCount(depot));
        System.out.println(depotmapper.showListPage(depot));
        return map;
    }

    public  Map<String, Object> showDnum(Depot depot) {
        Map<String,Object> map = new HashMap<>();
        int i = depotmapper.showDnu(depot);
        if(i>=0&&i<30){
            map.put("msg", "库存不足，请尽快补充！ 剩余库存："+i);
        }else if(i>30){
            map.put("msg", "剩余库存："+i);
        }
        else{
            map.put("msg", "未查询到该货物！！");
        }
        return map;
    }

    public Map<String, Object> selectName(Depot depot) {
        Map<String,Object> map = new HashMap<>();
        int i = depotmapper.selectName(depot);
        if(i>0){
            map.put("msg", "该货物已存在！！");
        }else{
            map.put("msg", "该货物名未存在！！");
        }
        return map;
    }

    public Map<String, Object> selectDsell(Depot depot) {
        Map<String,Object> map = new HashMap<>();
        depotmapper.selectDsell(depot);
        map.put("data", depotmapper.selectDsell(depot));
        return map;
    }
    public Map<String, Object> selectDtype(Depot depot) {
        Map<String,Object> map = new HashMap<>();
        map.put("data", depotmapper.selectDtype(depot));
        return map;
    }
}