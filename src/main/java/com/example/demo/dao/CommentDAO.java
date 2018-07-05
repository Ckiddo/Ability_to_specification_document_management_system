package com.example.demo.dao;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDAO {

    @Select(value = "SELECT comment.member_name,comment.comment_detailmcom_time from proposal,comment where(proposal.p_id=comment.p_id)")
    List<Comment> getAllComment();
}
