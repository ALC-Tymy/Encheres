package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Proposal;

import java.util.List;

public interface ProposalRepository {


    List<Proposal> readAll();

    List<Proposal> readFullAll();

    List<Proposal> readProposalByIdArticle(long id);

    Proposal readById(long id);


    void updateProposal(Proposal proposal);

    void deleteProposal(long id);

    List<Proposal> readProposalECByIdUser(long id);

    // Récupère la liste des propositions pour des ventes TERMINÉES selon l'ID user
    List<Proposal> readProposalVDLVByIdUser(long id);

    void updateRankByArticle(long id);

    void createProposal(Proposal proposal);

    boolean checkUserRankOne(long id_article, long id_buyer);

    long checkWalletPointToPointProposal(long id_buyer);

    void creditWalPendingAndDebitWalPoint(long id_buyer, int point_proposal);

    void creditWalPointAndDebitWalPending(long id_buyer, int point_proposal);

    Long getUserIdByRankOne(long id_article);

    void updatePointProposalToFinalPoint(long id_article, int point_proposal);
}
