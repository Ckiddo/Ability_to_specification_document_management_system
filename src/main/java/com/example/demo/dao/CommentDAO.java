package com.example.demo.dao;

import com.example.demo.entity.Comment;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDAO {


    @Insert(value = "INSERT INTO comment(comment.`member_name`,comment.`p_id`,comment.`comment_detail`,"+
            "comment.`com_time`,comment.`agree`)\n"+
            "VALUE(#{member_name},#{p_id},#{comment_detail},#{com_time},#{agree})")
    int insert(Comment comment);


    @Select(value = "SELECT comment.member_name,comment.comment_detail,comment.com_time from proposal,comment where(proposal.p_id=comment.p_id)")
    List<Comment> getAllComment();

    @Select(value = "select * from comment where p_id = #{p_id}")
    List<Comment> getcomment(int p_id);
}
