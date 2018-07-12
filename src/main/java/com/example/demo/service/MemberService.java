package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    boolean insert(Member member);

    List<Member> getAllMember();

    int findname(Member member);

    int getusergroup(Member member);

    boolean update(Member member);

    Member findaname(Member member);
    boolean deletemember(String name);
    boolean updategroup(String name);

    List<Member> findref(String refname);
}
