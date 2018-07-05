package com.example.demo.service.impl;


import com.example.demo.dao.ProposalDAO;
import com.example.demo.entity.Proposal;
import com.example.demo.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalDAO proposalDAO;

    @Override
    public Proposal getProposal(){
        return proposalDAO.getProposal();
    }
}
