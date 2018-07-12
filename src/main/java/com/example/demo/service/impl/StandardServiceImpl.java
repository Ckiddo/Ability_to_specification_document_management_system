package com.example.demo.service.impl;

import com.example.demo.entity.Standard;
import com.example.demo.service.StandardService;
import com.example.demo.dao.StandardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    private StandardDAO standardDAO;

    @Override
<<<<<<< HEAD
    public List<Standard> getAllStandard(){
        return standardDAO.getAllStandard();
    }
=======
    public List<Standard> getallStandard(){
        return standardDAO.getallstandard();
    }

    @Override
    public boolean insert(Standard standard) {
        System.out.println("miao");

        if (null == standard){
            return false;
        }
        // do something...
        if( standardDAO.insert(standard)==0)
        {
            System.out.println("返回0");
        }
        else{
            System.out.println("返回非0");
        }
        return true;
    }

    @Override
    public Standard getonestandard(int s_id) {
        Standard standards = standardDAO.getonestandard(s_id);
        return standards;
    }

>>>>>>> wpf2
}
