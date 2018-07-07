package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    boolean insert(Member member);

    List<Member> getAllMember();

    boolean findname(Member member);
}
