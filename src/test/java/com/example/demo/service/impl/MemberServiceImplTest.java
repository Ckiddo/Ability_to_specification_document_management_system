package com.example.demo.service.impl;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MemberServiceImplTest {
    @Autowired
    MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
    @Autowired
    MemberDAO memberDAO;
    @Autowired
    Member member = new Member();

    @Test
    public void getAllMember() {
        Assert.assertEquals(memberDAO.getAllMember(),memberServiceImpl.getAllMember());
    }

    @Test
    public void insert() {

    }

    @Test
    public void findname() {
        Assert.assertEquals(0,memberServiceImpl.findname(member));

    }

    @Test
    public void getusergroup() {

    }

    @Test
    public void deletemember() {
        Assert.assertTrue(memberServiceImpl.deletemember("ck"));
    }

    @Test
    public void updategroup() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findaname() {
//        Assert.assertEquals(memberServiceImpl.findname(member),null);
//        Assert.assertEquals(memberServiceImpl.findname(new Member(),memberDAO.find(member.getName())));
    }

    @Test
    public void findref() {

    }
}