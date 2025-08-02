package com.elform;

public class User {
    private String name;
    private String pass;
    private String addr;
    private boolean news;
    private String[] fw;
    private String gender;
    private String num;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getAddr() { return addr; }
    public void setAddr(String addr) { this.addr = addr; }

    public boolean isNews() { return news; }
    public void setNews(boolean news) { this.news = news; }

    public String[] getFw() { return fw; }
    public void setFw(String[] fw) { this.fw = fw; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getNum() { return num; }
    public void setNum(String num) { this.num = num; }
}
