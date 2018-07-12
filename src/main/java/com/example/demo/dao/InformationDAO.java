package com.example.demo.dao;

import com.example.demo.entity.Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Update;
>>>>>>> wpf2

import java.util.List;

@Mapper
public interface InformationDAO {

    @Select(value = "SELECT * FROM information")
    List<Information> getAllInformation();
<<<<<<< HEAD
=======



>>>>>>> wpf2
}
