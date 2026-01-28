package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Proposal;

import java.util.List;

public interface ProposalRepository {
    void createProposal(Proposal proposal);

    List<Proposal> readAll();

    List<Proposal> readFullAll();

    Proposal readById(long id);


    void updateProposal(Proposal proposal);

    void deleteProposal(long id);
}
