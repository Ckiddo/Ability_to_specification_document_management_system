package com.example.demo.dao;


import com.example.demo.entity.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StandardDAO {

<<<<<<< HEAD
    @Select(value = "SELECT * FROM standard")
=======
    @Select(value = "SELECT * FROM standards")
>>>>>>> ck
    List<Standard> getAllStandard();
}
