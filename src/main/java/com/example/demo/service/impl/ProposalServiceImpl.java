package com.example.demo.service.impl;


import com.example.demo.dao.ProposalDAO;

import com.example.demo.entity.Member;
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

    public  List<Proposal> getallproposal(){
        return proposalDAO.getallproposal();
    }
    @Override
    public Proposal getoneproposal(int p_id){
        return proposalDAO.getoneproposal(p_id);
    }
    @Override
    public boolean insert(Proposal proposal) {
        System.out.println("miao");

        if (null == proposal){
            return false;
        }
        // do something...
        if( proposalDAO.insert(proposal)==0)
        {
            System.out.println("返回0");
        }
        else{
            System.out.println("返回非0");
        }
        return true;
    }

    @Override
    public List<Proposal> getproposal(String author) {
        List<Proposal> proposal1=proposalDAO.getproposal(author);
        return proposal1;
    }

    @Override
    public List<Proposal> getlevelpro(String status) {
        List<Proposal> proposal1=proposalDAO.getlevelpro(status);
        return proposal1;
    }

    @Override
    public boolean deleteproposal(int p_id){
        proposalDAO.delete(p_id);
        return true;
    }


        @Override
        public void updateAg(Proposal proposal)
        {
            System.out.println("内部的"+proposal);
            proposalDAO.updateAgreeById(proposal);
        }

    @Override
    public void updateDisAg(Proposal proposal)
    {
        proposalDAO.updateDisagreeById(proposal);
    }

    @Override
    public void changestatus(int it,String status)
    {
        Proposal proposal=new Proposal();
        proposal.setP_id(it);
        proposal.setStatus(status);
        System.out.println("传进来的推荐it是"+it+"status是：：：：："+status);
        proposalDAO.changestatus(proposal);
    }


}
