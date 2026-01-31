package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Proposal;

import java.util.List;

public interface ProposalRepository {
    void createProposal(Proposal proposal);

    List<Proposal> readAll();

    List<Proposal> readFullAll();

    List<Proposal> readProposalByIdArticle(long id);

    Proposal readById(long id);


    void updateProposal(Proposal proposal);

    void deleteProposal(long id);

    List<Proposal> readProposalECByIdUser(long id);

    // Récupère la liste des propositions pour des ventes TERMINÉES selon l'ID user
    List<Proposal> readProposalVDLVByIdUser(long id);
}
