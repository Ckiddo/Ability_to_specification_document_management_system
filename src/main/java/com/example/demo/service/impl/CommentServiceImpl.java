package com.example.demo.service.impl;

import com.example.demo.dao.CommentDAO;
import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> getAllComment(){
        return commentDAO.getAllComment();
    }
}
