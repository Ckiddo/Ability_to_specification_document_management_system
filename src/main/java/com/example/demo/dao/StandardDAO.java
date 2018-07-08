package com.example.demo.dao;


import com.example.demo.entity.Proposal;
import com.example.demo.entity.Standard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StandardDAO {


    @Select(value = "SELECT * FROM standard")

    List<Standard> getAllStandard();

    @Insert(value = "INSERT INTO standard(standard.`id`,standard.`name`,standard.`author`,standard.`editDate`,"+
            "proposal.`standard_content`)\n"+
            "VALUE(#{p_id},#{name},#{author},#{close_time},#{status},#{content},#{agree_num},#{disagree_num},#{sub_time})")
    int insert(Standard standard);


    @Select(value = "select * from standard where name = #{name}")
    List<Standard> getstandard(String name);

    @Select(value = "select * from standard")
    List<Standard> getallstandard();

}
