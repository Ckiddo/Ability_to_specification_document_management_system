package com.example.demo.service.impl;

import com.example.demo.dao.InformationDAO;
import com.example.demo.entity.Information;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class InformationServiceImplTest {
    @Autowired
    InformationServiceImpl informationServiceImpl = new InformationServiceImpl();
    @Autowired
    InformationDAO informationDAO = new InformationDAO() {
        @Override
        public List<Information> getAllInformation() {
            return null;
        }
    };
    @Test(expected = NullPointerException.class)
    public void getAllInformation() {
        Assert.assertEquals(informationServiceImpl.getAllInformation(),informationDAO.getAllInformation());
    }
}