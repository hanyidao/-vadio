package com.svs.bupei.vadio.pojo;

/**
 *用户表格user：主键uid，
 * 账号username，密码pwd，
 * 昵称uname（不可重复），
 * 客户类别utype（用户或商家），
 * 联系电话ucall，
 * 微信号uwei，
 * 地址uaddress，
 * 头像ulogo（可空），
 * 详细介绍usuggest，
 * 是否vip uvip，
 * 注册时间udate，
 * 上次登录时间uindate，
 * 是否被管理删除udelete
 */
public class User {
    private int uid;
    private String username;
    private String pwd;
    private String sex;
    private String uname;
    private String utype;
    private String ucall;
    private String uwei;
    private String uaddress;
    private String ulogo;
    private String usuggest;
    private String udate;
    private String uindate;
    private String Lpath;
    private String selectucall;
    private String selectuname;
    private int page;
    private int limit;

    public String getLpath() {
        return Lpath;
    }

    public void setLpath(String lpath) {
        Lpath = lpath;
    }

    public String getSelectucall() {
        return selectucall;
    }

    public void setSelectucall(String selectucall) {
        this.selectucall = selectucall;
    }


    public int getPage() {
        return (page-1)*limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSelectuname() {
        return selectuname;
    }

    public void setSelectuname(String selectuname) {
        this.selectuname = selectuname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getUcall() {
        return ucall;
    }

    public void setUcall(String ucall) {
        this.ucall = ucall;
    }

    public String getUwei() {
        return uwei;
    }

    public void setUwei(String uwei) {
        this.uwei = uwei;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUlogo() {
        return ulogo;
    }

    public void setUlogo(String ulogo) {
        this.ulogo = ulogo;
    }

    public String getUsuggest() {
        return usuggest;
    }

    public void setUsuggest(String usuggest) {
        this.usuggest = usuggest;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getUindate() {
        return uindate;
    }

    public void setUindate(String uindate) {
        this.uindate = uindate;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
