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
    public List<Standard> getAllStandard(){
        return standardDAO.getAllStandard();
    }
}
