package com.example.demo.service;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Standard;

import java.util.List;

public interface StandardService {
    List<Standard> getallStandard();
    public boolean insert(Standard standard);
    List<Standard> getproposal(String name);
}
