package com.svs.bupei.vadio.pojo;

/**
 * 点击量表
 */
public class Vclick {
    /**
     * 主键
     */
    private int vcid;
    /**
     * 点击时间
     */
    private String vcdate;
    /**
     * 点击者
     */
    private String vcuname;
    /**
     * 被点击视频主键
     */
    private String vid;

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

    public int getVcid() {
        return vcid;
    }

    public void setVcid(int vcid) {
        this.vcid = vcid;
    }

    public String getVcdate() {
        return vcdate;
    }

    public void setVcdate(String vcdate) {
        this.vcdate = vcdate;
    }

    public String getVcuname() {
        return vcuname;
    }

    public void setVcuname(String vcuname) {
        this.vcuname = vcuname;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String uname) {
        this.vid = uname;
    }
}
