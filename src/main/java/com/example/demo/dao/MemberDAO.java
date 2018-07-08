package com.example.demo.dao;

import com.example.demo.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Mapper
public interface MemberDAO {

    @Insert(value = "INSERT INTO member(member.`name`,member.`password`,member.`sex`,member.`birthday`,"+
            "member.`homeaddress`,member.`contactinfor`,member.`referees`,member.`industrybranch`,"+
            "member.`specialcommittee`)\n" +
            "VALUE(#{name},#{password},#{sex},#{birthday},#{homeaddress},#{contactinfor},#{referees},#{industrybranch},#{specialcommittee})")


   /* @Insert(value = "INSERT INTO member(name,password,sex,birthday,homeaddress,contactinfor,referees,insustrybranch,specialcommittee"+
            "VALUE(#{name},#{password},#{sex},#{birthday},#{homeaddress},#{contactinfor},#{referees},#{industrybranch},#{specialcommittee})")*/
    int insert(Member member);

    @Select(value = "select * from member where name = #{name}")
    Member find(String name);

    @Select(value = "SELECT * FROM member")
    List<Member> getAllMember();



}
