package com.svs.bupei.vadio.pojo;

/**
 * 商家视频表
 */
public class Vadio {

    /**
     * 主键
     */
    private int vid;

    /**
     * 视频存储地址
     */
    private String vpath;

    /**
     * 视频名字
     */
    private String vname;

    /**
     * 视频种类
     */
    private String vtype;

    /**
     * 所属用户
     */
    private String uname;

    /**
     * 上传时间
     */
    private String vdate;

    /**
     * 审核是否通过
     */
    private String vsuccess = "未通过";

    /**
     * 推送优先级
     */
    private String vlv = "1";

    /**
     * 是否被管理员删除
     */
    private String vdelete = "未删除";

    /**
     * 用于分页
     */
    private int page = 1;
    private int limit = 10;

//    /**
//     * 用于接收视频
//     */
//    private Part vadio;
//
//    public Part getVadio() {
//        return vadio;
//    }
//
//    public void setVadio(Part vadio) {
//        this.vadio = vadio;
//    }

    public int getPage() {
        return (page - 1) * limit;
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

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVpath() {
        return vpath;
    }

    public void setVpath(String vpath) {
        this.vpath = vpath;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getVdate() {
        return vdate;
    }

    public void setVdate(String vdate) {
        this.vdate = vdate;
    }

    public String getVsuccess() {
        return vsuccess;
    }

    public void setVsuccess(String success) {
        this.vsuccess = success;
    }

    public String getVlv() {
        return vlv;
    }

    public void setVlv(String vlv) {
        this.vlv = vlv;
    }

    public String getVdelete() {
        return vdelete;
    }

    public void setVdelete(String vdelete) {
        this.vdelete = vdelete;
    }
}
