package com.example.demo.entity;


import lombok.Data;

@Data
public class Member {
    private  String name;
    private  String password;
    private  String sex;
    private  String birthday;
    private  String homeaddress;
    private  String contactinfor;
    private  String referees;
    private  String industrybranch;
    private  String specialcommittee;
    private  Integer usergroup;

    private  String company;
    private  String title;
    private  String position;
    private  String phonenum;
    private  String email;
    private  String wechat;

    private  String ref_content;
    private  String refed;

    public void setUsergroup(Integer setnum){
        usergroup=setnum;
    };

}

