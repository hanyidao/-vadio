package com.svs.bupei.vadio.pojo;

public class Buy {
    private int bid;
    private String buname;
    private String uname;
    private int bnum;
    private int bmoney;
    private String bdate;
    private String baddress;
    private String bcall;
    private String bname;
    private String btype;
    private String selectuname;
    private String selectbtype;
    private String dname;
    private int page;
    private int limit;
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBuname() {
        return buname;
    }

    public void setBuname(String buname) {
        this.buname = buname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }

    public int getBmoney() {
        return bmoney;
    }

    public void setBmoney(int bmoney) {
        this.bmoney = bmoney;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public String getBcall() {
        return bcall;
    }

    public void setBcall(String bcall) {
        this.bcall = bcall;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getSelectuname() {
        return selectuname;
    }

    public void setSelectuname(String selectuname) {
        this.selectuname = selectuname;
    }

    public String getSelectbtype() {
        return selectbtype;
    }

    public void setSelectbtype(String selectbtype) {
        this.selectbtype = selectbtype;
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
}