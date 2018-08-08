package com.example.demo.service.impl;

import com.example.demo.dao.InformationDAO;
import com.example.demo.entity.Information;
import com.example.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationDAO informationDAO;

    @Override
    public List<Information> getAllInformation(){
        return informationDAO.getAllInformation();
    }

}
