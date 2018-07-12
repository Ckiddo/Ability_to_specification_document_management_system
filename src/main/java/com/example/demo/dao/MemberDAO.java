package com.example.demo.dao;

import com.example.demo.entity.Member;

import org.apache.ibatis.annotations.*;
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

    @Delete(value = "DELETE FROM `docsmanagesys`.`member` WHERE `name`=#{name}")
    int delete(String name);
    @Update(value="UPDATE `docsmanagesys`.`member` SET `usergroup`='1' WHERE `name`=#{name}")
    int uodategroup(String name);

    @Select(value = "select * from member where name = #{name}")
    Member find(String name);

    @Select(value = "SELECT * FROM member")
    List<Member> getAllMember();

    @Update(value = "UPDATE member SET member.company = #{company},member.title = #{title},member.position = #{position}," +
            "member.phonenum = #{phonenum},member.email = #{email}," +
            "member.wechat = #{wechat},member.ref_content = #{ref_content},member.refed = #{refed} WHERE member.name = #{name}")
    int update(Member member);

    @Select(value = "select * from member where referees = #{refname}")
    List<Member> findref(String refname);

}
