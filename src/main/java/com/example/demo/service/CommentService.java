package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();
    List<Comment> getcomment(int p_id);
    boolean insert(Comment comment);

}
