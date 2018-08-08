package com.example.demo.service.impl;

import com.example.demo.dao.CommentDAO;
import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommentServiceImplTest {
    @Autowired
    CommentServiceImpl commentServiceImpl = new CommentServiceImpl();
    @Autowired
    CommentDAO commentDAO;
    @Test(expected = NullPointerException.class)
    public void getAllComment() {
        Assert.assertEquals(commentServiceImpl.getAllComment(),commentDAO.getAllComment());
    }

    @Test(expected = NullPointerException.class)
    public void insert() throws Exception{
        Assert.assertTrue(commentServiceImpl.insert(new Comment()));
        Assert.assertFalse(commentServiceImpl.insert(null));
    }

    @Test(expected = NullPointerException.class)
    public void getcomment() {
        Assert.assertEquals(commentServiceImpl.getcomment(1),commentDAO.getcomment(1));
    }
}