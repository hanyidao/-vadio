package com.svs.bupei.vadio.service;

import com.svs.bupei.Constants;
import com.svs.bupei.vadio.mapper.VadioMapper;
import com.svs.bupei.vadio.pojo.Vadio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class VadioService {

    @Autowired
    VadioMapper vadioMapper;

    /**
     * 查询所有数据（模糊查询+分页）
     * @param vadio 前台返回的数据模型
     * @return 所有数据
     */
    public Map<String, Object> selectAllVadio(Vadio vadio)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("data",vadioMapper.selectAllVadio(vadio));
        map.put("count",vadioMapper.selectCountVadio(vadio));
        return map;
    }

    /**
     * 添加一条信息
     * @param part 视频流
     * @param vadio
     * @return 操作结果
     */
    public Map<String, Object> insertVadio(Part part,Vadio vadio)
    {
        Map<String, Object> map = new HashMap<>();

        String path = Constants.SAVE_PATH; //视频存储地址
        String uuid = UUID.randomUUID().toString();

        if(part != null)
        {
            String header = part.getHeaders("content-disposition").toString();
            String end = header.substring(header.lastIndexOf(".") + 1,header.length() - 2);
            if(Constants.VADIO_TYPE.indexOf(end) > -1)
            {
                try {
                    path = path + uuid + '.' + end;
                    vadio.setVpath(path);
                    part.write(path);
                    int i = vadioMapper.insertVadio(vadio);
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
                map.put("msg", Constants.ERROR_UPLOAD_VADIO);
                return map;
            }
        }else {
            map.put("msg", Constants.ERROR_NOTHING_VADIO);
            return map;
        }
    }

    /**
     * 查询所有已删除数据
     * @param vadio
     * @return
     */
    public Map<String,Object> selectDeleteVadio(Vadio vadio)
    {
        Map<String,Object> map = new HashMap<>();

        map.put("data",vadioMapper.selectDeleteVadio(vadio));
        map.put("count",vadioMapper.selectDeleteCountVadio(vadio));

        return map;
    }

    /**
     * 删除一条vadio数据
     * @param vid
     * @return 操作结果
     */
    public Map<String,Object> deleteVadio(int vid)
    {
        Map<String,Object> map = new HashMap<>();
        int i = vadioMapper.deleteVadio(vid);
        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_DELETE);
        }else
        {
            map.put("msg", Constants.ERROR_DELETE);
        }
        return map;
    }

    /**
     * 更改一条数据
     * @param vadio
     * @return 操作结果
     */
    public Map<String, Object> updateVadio(Vadio vadio)
    {
        Map<String,Object> map = new HashMap<>();
        int i = vadioMapper.updateVadio(vadio);
        if(i > 0)
        {
            map.put("msg", Constants.SUCCESS_UPDATE);
        }else
        {
            map.put("msg", Constants.ERROR_UPDATE);
        }
        return map;
    }
}
