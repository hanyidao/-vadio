package com.svs.bupei.vadio.pojo;

/**
 * 视频点赞表
 */
public class Good {

    /**
     * 主键
     */
    private int gid;
    /**
     * 点赞时间
     */
    private String gdate;
    /**
     * 点赞内容（0好评，1差评）
     */
    private int gnum;
    /**
     * 点赞用户
     */
    private String uname;
    /**
     * 被点赞视频
     */
    private int vid;

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

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
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
}
