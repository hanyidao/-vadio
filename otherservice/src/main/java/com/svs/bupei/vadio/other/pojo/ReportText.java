package com.svs.bupei.vadio.other.pojo;

/**
 * 举报评论表
 */
public class ReportText {

    /**
     * 举报评论表主键
     */
    private int reid;
    /**
     * 评论question表主键
     */
    private int qid;
    /**
     * 用户昵称
     */
    private String uname;
    /**
     * 举报内容
     */
    private String retext;
    /**
     * 举报时间
     */
    private String redate;
    /**
     * 举报是否同意
     */
    private String resuccess = "待处理";

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

    /**
     * 分页
     */
    private int page;
    private int limit;

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRetext() {
        return retext;
    }

    public void setRetext(String retext) {
        this.retext = retext;
    }

    public String getRedate() {
        return redate;
    }

    public void setRedate(String redate) {
        this.redate = redate;
    }

    public String getResuccess() {
        return resuccess;
    }

    public void setResuccess(String resuccess) {
        this.resuccess = resuccess;
    }
}
