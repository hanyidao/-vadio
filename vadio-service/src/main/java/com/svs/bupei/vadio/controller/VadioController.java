package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.Vadio;
import com.svs.bupei.vadio.service.VadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.Map;

@RestController
@RequestMapping("/vadio")
public class VadioController {

    @Autowired
    VadioService vadioService;

    @PostMapping("/selectAllVadio")
    public Map<String, Object> selectAllVadio(Vadio vadio)
    {
        return vadioService.selectAllVadio(vadio);
    }

    @PostMapping("/selectDeleteVadio")
    public Map<String,Object> selectDeleteVadio(Vadio vadio)
    {
        return vadioService.selectDeleteVadio(vadio);
    }

    @PostMapping("/insertVadio")
    public Map<String,Object> insertVadio(@RequestParam("vadio") Part part, Vadio vadio)
    {
        return vadioService.insertVadio(part,vadio);
    }

    @DeleteMapping("/deleteVadio/{vid}")
    public Map<String, Object> deleteVadio(@PathVariable("vid") int vid)
    {
        return vadioService.deleteVadio(vid);
    }

    @PostMapping("/updateVadio")
    public Map<String,Object> updateVadio(Vadio vadio)
    {
        return vadioService.updateVadio(vadio);
    }


}
