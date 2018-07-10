package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;

import java.util.List;

public interface ProposalService {
    List<Proposal> getallproposal();
    public boolean insert(Proposal proposal);
    List<Proposal> getproposal(String author);
    Proposal getoneproposal(int p_id);
    boolean deleteproposal(int p_id);

    void updateAg(Proposal proposal);
    void updateDisAg(Proposal proposal);
}
