package com.example.demo.service.impl;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberDAO memberDAO;

    @Override

    public boolean insert(Member member) {
        System.out.println("miao");

        if (null == member){
            return false;
        }
        // do something...
        if( memberDAO.insert(member)==0)
        {
            System.out.println("返回0");
        }
        else{
            System.out.println("返回非0");
        }

        return true;
    }
}

