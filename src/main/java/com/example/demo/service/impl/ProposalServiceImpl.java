package com.example.demo.service.impl;


import com.example.demo.dao.ProposalDAO;
import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;
import com.example.demo.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalDAO proposalDAO;

    @Override
    public  List<Proposal> getallproposal(){
        return proposalDAO.getallproposal();
    }

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
    public boolean deleteproposal(int p_id){
        proposalDAO.delete(p_id);
        return true;
    }


        @Override
        public void updateAg(Proposal proposal)
        {
            proposalDAO.updateAgreeById(proposal);
        }

    @Override
    public void updateDisAg(Proposal proposal)
    {
        proposalDAO.updateDisagreeById(proposal);
    }

}
