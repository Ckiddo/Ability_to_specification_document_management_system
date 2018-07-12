package com.example.demo.service;

<<<<<<< HEAD
=======
import com.example.demo.entity.Member;
>>>>>>> wpf2
import com.example.demo.entity.Proposal;

import java.util.List;

public interface ProposalService {
<<<<<<< HEAD
    Proposal getProposal();
=======
    List<Proposal> getallproposal();
    public boolean insert(Proposal proposal);
    List<Proposal> getproposal(String author);
    Proposal getoneproposal(int p_id);
    boolean deleteproposal(int p_id);
    List<Proposal> getlevelpro(String status);
    void updateAg(Proposal proposal);
    void updateDisAg(Proposal proposal);
    void changestatus(int it,String status);
>>>>>>> wpf2
}
