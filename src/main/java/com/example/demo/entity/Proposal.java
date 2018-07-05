package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
//import java.util.List;

@Data
public class Proposal {

    private int p_ID;
    private String name;
    private String author;
    private Date  close_time;
    private String status;
    private String content;
    private int agree_num;
    private int disagree_num;
    private Date sub_time;
    //private List<Comment> commontList;
}
