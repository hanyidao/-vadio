package com.svs.bupei.vadio.pojo;

public class Answer {

    /**
     * 主键
     */
    private int aid;
    /**
     * 所属用户
     */
    private String uname;
    /**
     * 关键字
     */
    private String akeyword;
    /**
     * 回复内容
     */
    private String atext;


    /**
     * 分页
     */
    private int page = 1;
    private int limit = 10;

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


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAkeyword() {
        return akeyword;
    }

    public void setAkeyword(String akeyword) {
        this.akeyword = akeyword;
    }

    public String getAtext() {
        return atext;
    }

    public void setAtext(String atext) {
        this.atext = atext;
    }
}
