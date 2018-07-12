package com.example.demo.dao;


<<<<<<< HEAD
import com.example.demo.entity.Standard;
=======
import com.example.demo.entity.Proposal;
import com.example.demo.entity.Standard;
import org.apache.ibatis.annotations.Insert;
>>>>>>> wpf2
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StandardDAO {


<<<<<<< HEAD
    @Select(value = "SELECT * FROM standards")

    List<Standard> getAllStandard();
=======
    @Select(value = "SELECT * FROM standard")

    List<Standard> getAllStandard();

    @Insert(value = "INSERT INTO standard(standard.`s_id`,standard.`name`,standard.`editDate`,"+
            "proposal.`standard_content`)\n"+
            "VALUE(#{s_id},#{name},#{editDate},#{standard_content})")
    int insert(Standard standard);


    @Select(value = "select * from standard where s_id = #{s_id}")
    Standard getonestandard(int s_id);

    @Select(value = "select * from standard")
    List<Standard> getallstandard();

>>>>>>> wpf2
}
