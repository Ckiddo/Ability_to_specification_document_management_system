package com.example.demo.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Comment {// 评论
    private String member_name; //评论人编号
    private int p_id; //提案的编号（为了将评论表和提案表相联系）
    private String comment_detail; //评论内容
    private String com_time; //评论时间
    private boolean agree; //是否同意
}
