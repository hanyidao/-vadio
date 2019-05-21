package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username,pwd,sex,uname,utype,ucall,uwei,uaddress,ulogo,usuggest,udate,uindate) values(#{username},#{pwd},#{sex},#{uname},#{utype},#{ucall},#{uwei},#{uaddress},#{ulogo},#{usuggest},#{udate},#{uindate})")
    int addUser(User user) ;

    @Delete("delete from user where uid= #{uid}")
    int deleteUser(String uid) ;

    @Update("update user set username=#{username},pwd=#{pwd},sex=#{sex},uname=#{uname},utype=#{utype},ucall=#{ucall},uwei=#{uwei},uaddress=#{uaddress},ulogo=#{ulogo},usuggest=#{usuggest},udate=#{udate},uindate=#{uindate} where uid=#{uid}")
    int updateUser(User user) ;

    @Select("select count(uid) num from user where ucall like concat(ifNull(#{selectucall},''),'%') and uname like concat(ifNull(#{selectuname},''),'%')")
    int showListPageCount(User user) ;

    @Select("select * from user where ucall like concat(ifNull(#{selectucall},''),'%') and uname like concat(ifNull(#{selectuname},''),'%') limit #{page},#{limit}")
    List<Map<String, Object>> showListPage(User user) ;

    @Select("select * from user where username=#{username}and pwd=#{pwd}")
    List<Map<String, Object>> selectAll(User user);

    @Select("select count(uid) from user where ucall=#{ucall}")
    int selectUcall(User user);

    @Select("select count(uid) from user where uname=#{uname}")
    int selectUname(User user);

    @Select("select count(uid) from user where username=#{username}")
    int selectUsername(User user);

}