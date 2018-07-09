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

    @Override
    public boolean insert(Comment comment) {
        System.out.println("miao");
        if (null == comment){
            return false;
        }
        // do something...
        if( commentDAO.insert(comment)==0)
        {
            System.out.println("返回0");
        }
        else{
            System.out.println("返回非0");
        }
        return true;
    }


    @Override
    public List<Comment> getcomment(int p_id){
        return commentDAO.getcomment(p_id);
    }
}
