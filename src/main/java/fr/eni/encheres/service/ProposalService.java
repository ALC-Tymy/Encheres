package fr.eni.encheres.service;

import fr.eni.encheres.entity.Proposal;
import java.util.List;

public interface ProposalService {

    void createProposal(Proposal proposal);
    List<Proposal> readAll();
    Proposal readById(long id);
    void updateProposal(Proposal proposal);
    void deleteProposal(long id);
    List<Proposal> readProposalECByIdUser(long id);

    List<Proposal> readProposalVDLVByIdUser(long id);

    List<Proposal> readProposalByIdArticle(long id);
}
