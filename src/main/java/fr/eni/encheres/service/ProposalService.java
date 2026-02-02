package fr.eni.encheres.service;

import fr.eni.encheres.entity.Proposal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProposalService {

    List<Proposal> readAll();

    Proposal readById(long id);

    void updateProposal(Proposal proposal);

    void deleteProposal(long id);

    List<Proposal> readProposalECByIdUser(long id);

    List<Proposal> readProposalVDLVByIdUser(long id);

    List<Proposal> readProposalByIdArticle(long id);

    @Transactional
    void createProposal(long id_article, int pointProposal);

    void updateRankByArticle(long id);
}
