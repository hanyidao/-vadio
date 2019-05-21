package com.svs.bupei.vadio.other.pojo;

/**
 * 举报视频表格
 */
public class Report {

    /**
     * 主键
     */
    private int rid;
    /**
     * 用户
     */
    private String uname;
    /**
     * 视频主键
     */
    private int vid;
    /**
     * 举报内容
     */
    private String rtext;
    /**
     * 举报时间
     */
    private String rdate;
    /**
     * 是否通过
     */
    private String rsuccess = "待处理";

    /**
     * 分页
     */
    private int page;
    private int limit;

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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getRtext() {
        return rtext;
    }

    public void setRtext(String rtext) {
        this.rtext = rtext;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getRsuccess() {
        return rsuccess;
    }

    public void setRsuccess(String rsuccess) {
        this.rsuccess = rsuccess;
    }
}
