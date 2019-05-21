package com.svs.bupei.vadio.controller;

import com.svs.bupei.vadio.pojo.User;
import com.svs.bupei.vadio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Part;
import java.util.Map;



@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    /**
     *查询user用户表所有数据
     */
    @PostMapping("/show")
    public Map<String,Object> showListPage(@RequestBody User user){
        return userService.showListPage(user);
    }


    /**
     *修改user用户表所有数据
     *包括头像修改
     */
    @PostMapping("/update")
    public Map<String, Object> update(@RequestParam("image") Part part, User user) {
        return userService.updateUser(part,user);
    }

    /**
     *删除user用户表数据
     *uid：user表格主键
     */
    @DeleteMapping("/delete/{uid}")
    public String delete(@PathVariable("uid") String uid) {
        return  userService.deleteUser(uid);
    }

    /**
     *增加user用户表数据
     *包括头像
     */
    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody User user) {
        System.out.println(user);
        return userService.insertLogo(user);
    }

    /**
     * 查询昵称之类的所有
     *按账号密码
     */
    @PostMapping("/selectAll")
    public Map<String, Object> selectAll(@RequestBody User user) {
        System.out.println(222);
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPwd());
        return userService.selectAll(user);
    }
    /**
     * 查询手机号是否被使用
     */
    @PostMapping("/selectucall")
    public Map<String, Object> selectUcall(@RequestBody User user) {
        return userService.selectUcall(user);
    }
    /**
     * 查询昵称是否被使用
     */
    @PostMapping("/selectuname")
    public Map<String, Object> selectUname(@RequestBody User user) {
        return userService.selectUname(user);
    }

    @PostMapping("/selectusername")
    public Map<String, Object> selectUsername(@RequestBody User user) {
        System.out.println(111);
        return userService.selectUsername(user);
    }

}
