package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.Depot;
import com.svs.bupei.vadio.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.Map;

@RestController
@RequestMapping("/depot")
public class DepotController {
    @Autowired
    DepotService depotService;

    /**
     * 查询买家订单
     *支持模糊查询 按卖家名和货物类型
     */
    @PostMapping("/show")
    public Map<String,Object> showListPage( Depot depot){
        return depotService.showListPage(depot);
    }
    /**
     * 查询货物剩余个数
     *按货物名称查询
     */
    @PostMapping("/showdnum")
    public Map<String, Object> showDnum(Depot depot){
        return depotService.showDnum(depot);
    }

    /**
     * 查询商家货物名称是否重复
     * uname 商家 dname 货物名称
     * 给添加方法用
     */
    @PostMapping("/selectname")
    public Map<String, Object> selectName (Depot depot){
        return depotService.selectName(depot);
    }
    /**
     * 修改功能
     */
    @PostMapping("/update")
    public Map<String, Object> update(@RequestParam("image") Part part, Depot depot) {
        return depotService.updateDepot(part,depot);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{did}")
    public String delete(@PathVariable("did") String did) {
        return  depotService.deleteDepot(did);
    }
    /**
     * 添加功能
     */
    @PostMapping("/save")
    public Map<String, Object> save(@RequestParam("image") Part part, Depot depot) {
        return depotService.addDepot(part,depot);
    }
    /**
     * 查询所有未开始出售的货物
     * dsell=0
     */
    @PostMapping("/selectdsell")
    public Map<String, Object> selectDsell( Depot depot) {
        return depotService.selectDsell(depot);
    }

    /**
     * 按商家查询货物种类
     */
    @PostMapping("/selectdtype")
    public Map<String, Object> selecttype(Depot depot) {
        return depotService.selectDtype(depot);
    }

}