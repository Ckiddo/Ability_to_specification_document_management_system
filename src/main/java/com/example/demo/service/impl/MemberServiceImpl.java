package com.example.demo.service.impl;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberDAO memberDAO;

    @Override
    public List<Member> getAllMember() {
        return memberDAO.getAllMember();
    }

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

    @Override
    public int findname(Member member) {
        System.out.println("miao");
        Member member1 = memberDAO.find(member.getName());
     /*   System.out.println("输入的名字"+member.getName());
        System.out.println("输入的密码"+member.getPassword());
        System.out.println("数据库的名字"+member1.getName());
        System.out.println("数据库的密码"+member1.getPassword());*/
        if (null == member1){
            System.out.println("不存在用户名");
            return 0;                       // 不存在用户名为 0
        }
        // do something...
        else{
            if(member.getPassword().equals(member1.getPassword()))
                return 1; //存在 且密码正确正确为1
            else
                return 2;   //存在但密码不正确 为2
        }
    }


    public int getusergroup(Member member)
    {
        Member member1 = memberDAO.find(member.getName());

        if (null == member1){
            System.out.println("不存在用户名");
            return 0;
        }
        else
        return member1.getUsergroup();
    }
    public boolean deletemember(String name){
        memberDAO.delete(name);
        return true;
    }

    public boolean updategroup(String name){
        memberDAO.uodategroup(name);
        return true;
    }

    public boolean update(Member member){
        if (null == member){
            return false;
        }
        // do something...
        if( memberDAO.update(member)==0)
        {
            System.out.println("返回0");
        }
        else{
            System.out.println("返回非0");
        }

        return true;
    }
    public Member findaname(Member member) {
        System.out.println("miao");
        Member member1 = memberDAO.find(member.getName());
     /*   System.out.println("输入的名字"+member.getName());
        System.out.println("输入的密码"+member.getPassword());
        System.out.println("数据库的名字"+member1.getName());
        System.out.println("数据库的密码"+member1.getPassword());*/
        if (null == member1){
            System.out.println("不存在用户名");
            return null;                       // 不存在用户名为 0
        }
        // do something...
        else{
            return member1;
        }
    }

}

