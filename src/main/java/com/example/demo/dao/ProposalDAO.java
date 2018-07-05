package com.example.demo.dao;

import com.example.demo.entity.Proposal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProposalDAO {

    @Select(value = "SELECT * FROM proposal where(p_id=)")
    public Proposal getProposal();
}
