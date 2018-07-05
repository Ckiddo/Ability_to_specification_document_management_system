package com.example.demo.entity;

<<<<<<< HEAD
public class Information {
    int ID;
    String name;
    String company;
    String title;
    String position;
    String phonenum;
    String email;
    String wechat;
}
=======
import lombok.Data;

@Data
public class Information {    //信息维护中被修改的人员的属性
    private String name;
    private String company;
    private String title;
    private String position;
    private String phonenum;
    private String email;
    private String wechat;
}

>>>>>>> ck
