package com.example.demo.dao;

import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProposalDAO {

    @Select(value = "SELECT * FROM proposal where(p_id=)")
    public Proposal getProposal();

    @Insert(value = "INSERT INTO proposal(proposal.`p_id`,proposal.`name`,proposal.`author`,proposal.`close_time`,"+
            "proposal.`status`,proposal.`content`,proposal.`agree_num`,proposal.`disagree_num`,"+
            "proposal.`sub_time`)\n" +
            "VALUE(#{p_id},#{name},#{author},#{close_time},#{status},#{content},#{agree_num},#{disagree_num},#{sub_time})")
    int insert(Proposal proposal);

    @Select(value = "select * from proposal where author = #{author}")
    List<Proposal> getproposal(String author);

    @Select(value = "select * from proposal where p_id = #{p_id}")
    Proposal getoneproposal(int p_id);

    @Select(value = "select * from proposal")
    List<Proposal> getallproposal();
}
