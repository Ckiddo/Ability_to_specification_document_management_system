package com.example.demo.entity;

<<<<<<< HEAD
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
=======
import lombok.Data;

//import java.util.List;

@Data
public class Proposal {

    private int p_ID;
    private String name;
    private String author;
    private String close_time;
    private String status;
    private String content;
    private int agree_num;
    private int disagree_num;
    private String sub_time;
    //private List<Comment> commontList;
>>>>>>> ck
}
