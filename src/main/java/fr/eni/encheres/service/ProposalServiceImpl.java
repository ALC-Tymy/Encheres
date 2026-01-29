package fr.eni.encheres.service;

import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.repository.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService{

    ProposalRepository proposalRepository;

    public ProposalServiceImpl(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public void createProposal(Proposal proposal) {
        this.proposalRepository.createProposal(proposal);
    }

    @Override
    public List<Proposal> readAll() {
        return this.proposalRepository.readAll();
    }

    @Override
    public Proposal readById(long id) {
        return this.proposalRepository.readById(id);
    }

    @Override
    public void updateProposal(Proposal proposal) {
        this.proposalRepository.updateProposal(proposal);
    }

    @Override
    public void deleteProposal(long id) {

    }

    @Override
    public List<Proposal> readProposalECByIdUser(long id) {
        return proposalRepository.readProposalECByIdUser(id);
    }

    @Override
    public List<Proposal> readProposalVDLVByIdUser(long id){
        return proposalRepository.readProposalVDLVByIdUser(id);
    }
}
