package com.svs.bupei.vadio.pojo;

public class Depot {
    private int did;
    private String uname;
    private String dname;
    private String dtype;
    private String dprice;
    private String doverplus;
    private String dsell;
    private String selectuname;
    private String selectdtype;
    private String selectdsell;
    private String dlogo;
    private String dtext;
    private int page;
    private int limit;
    private String ulogo;

    public String getUlogo() {
        return ulogo;
    }

    public void setUlogo(String ulogo) {
        this.ulogo = ulogo;
    }

    public String getDlogo() {
        return dlogo;
    }

    public void setDlogo(String dlogo) {
        this.dlogo = dlogo;
    }

    public String getDtext() {
        return dtext;
    }

    public void setDtext(String dtext) {
        this.dtext = dtext;
    }

    public String getSelectdsell() {
        return selectdsell;
    }

    public void setSelectdsell(String selectdsell) {
        this.selectdsell = selectdsell;
    }
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDprice() {
        return dprice;
    }

    public void setDprice(String dprice) {
        this.dprice = dprice;
    }

    public String getDoverplus() {
        return doverplus;
    }

    public void setDoverplus(String doverplus) {
        this.doverplus = doverplus;
    }

    public String getDsell() {
        return dsell;
    }

    public void setDsell(String dsell) {
        this.dsell = dsell;
    }

    public String getSelectuname() {
        return selectuname;
    }

    public void setSelectuname(String selectuname) {
        this.selectuname = selectuname;
    }

    public String getSelectdtype() {
        return selectdtype;
    }

    public void setSelectdtype(String selectdtype) {
        this.selectdtype = selectdtype;
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