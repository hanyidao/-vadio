package com.svs.bupei.vadio.service;

import com.svs.bupei.MaFactory;
import com.svs.bupei.vadio.mapper.UserMapper;
import com.svs.bupei.Constants;
import com.svs.bupei.vadio.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserMapper usermapper;
    /**
     *删除功能
     */
    public String deleteUser(String uid){
       String flage ="";
        int i = usermapper.deleteUser(uid);
        if(i>0){
            flage=( "删除成功");
        }else{
            flage=( "删除失败");
        }
        return flage;
    }
    /**
     *查询昵称之类的所有功能
     * 按账号密码 返回数据
     */
    public Map<String, Object> selectAll(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("data",usermapper.selectAll(user));
        if(map.get("data") != null){
            map.put("msg", "登录成功");
        }else{
            map.put("msg", "登录失败");
        }
        return map;
    }
    /**
     *查询手机号是否被使用
     */
    public Map<String, Object> selectUcall (User user){
        Map<String,Object> map = new HashMap<>();
        int i = usermapper.selectUcall(user);
        if(i>0){
            map.put("msg", "该手机号已绑定");
        }else{
            map.put("msg", "该手机号未绑定");
        }
        return map;
    }
    /**
     *查询昵称是否被使用
     */
    public Map<String, Object> selectUname(User user){
        Map<String,Object> map = new HashMap<>();
        int i = usermapper.selectUname(user);
        if(i>0){
            map.put("msg", "该昵称已被使用，换一个试试吧");
        }else{
            map.put("msg", "该昵称未使用");
        }
        return map;
    }
    /**
     *查询用户名是否被使用
     */
    public Map<String, Object> selectUsername(User user){
        System.out.println(user.getUsername());
        System.out.println(user);
        Map<String,Object> map = new HashMap<>();
        int i = usermapper.selectUsername(user);
        if(i>0){
            map.put("msg", "用户名正确");
        }else{
            map.put("msg", "该用户名不存在");
        }
        return map;
    }


    /**
     *修改功能
     * 可修改头像
     */
    public Map<String, Object> updateUser(Part part,User user){
        Map<String, Object> map = new HashMap<>();

        String path = Constants.SAVE_PATH; //头像存储地址
        String uuid = UUID.randomUUID().toString();
        if(part != null)
        {
            String header = part.getHeaders("content-disposition").toString();
            String end = header.substring(header.lastIndexOf(".") + 1,header.length() - 2);
            if(Constants.LOGO_TYPE.indexOf(end) > -1)
            {
                try {
                    path = path + uuid + '.' + end;
                    user.setUlogo(path);
                    part.write(path);
                    int i = usermapper.updateUser(user);
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
    /**
     *添加功能
     * 可添加头像
     */
    public Map<String, Object> insertLogo( User user)
    {
        Map<String,Object> map = new HashMap<>();
            int i = usermapper.addUser(user);
            if(i > 0)
            {
                map.put("msg", "注册成功");

            }else
            {
                map.put("msg","注册失败");

            }

        return map;
    }
    /**
     *查询功能
     * page：分页
     * 支持模糊查询 按手机号ucall与昵称uname
     */
    public Map<String, Object> showListPage(User user) {
        Map<String, Object> map = MaFactory.createLayuiSelectMap(usermapper.showListPage(user), "ok", usermapper.showListPageCount(user));
        System.out.println(usermapper.showListPage(user));
        return map;
    }



}

