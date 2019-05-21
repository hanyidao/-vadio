package com.svs.bupei.vadio.pojo;

/**
 * 评论表
 */
public class Question {

    /**
     * 主键
     */
    private int qid;
    /**
     * 视频主键
     */
    private int vid;
    /**
     * 评论内容
     */
    private String qtext;
    /**
     * 评论用户
     */
    private String uname;
    /**
     * 评论时间
     */
    private String qdate;
    /**
     * 是否被管理员删除
     */
    private String qdelete = "未删除";

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

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getQtext() {
        return qtext;
    }

    public void setQtext(String qtext) {
        this.qtext = qtext;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getQdate() {
        return qdate;
    }

    public void setQdate(String qdate) {
        this.qdate = qdate;
    }

    public String getQdelete() {
        return qdelete;
    }

    public void setQdelete(String qdelete) {
        this.qdelete = qdelete;
    }
}
