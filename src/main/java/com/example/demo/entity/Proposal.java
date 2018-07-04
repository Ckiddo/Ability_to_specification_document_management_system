package com.example.demo.entity;

import java.util.List;

public class Proposal {

    int P_ID;
    String name;
    String author;
    java.util.Date  Close_time;
    String status;
    String content;
    int agree_num;
    int disagree_num;
    List<Comment> commontList;
}
