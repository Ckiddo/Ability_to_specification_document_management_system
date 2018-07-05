package com.example.demo.dao;


import com.example.demo.entity.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StandardDAO {

    @Select(value = "SELECT * FROM standards")
    List<Standard> getAllStandard();
}
