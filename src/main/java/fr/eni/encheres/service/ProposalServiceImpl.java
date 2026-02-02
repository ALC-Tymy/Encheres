package fr.eni.encheres.service;

import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.repository.ProposalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    private final ArticleService articleService;
    ProposalRepository proposalRepository;
    UserService userService;

    public ProposalServiceImpl(ProposalRepository proposalRepository, UserService userService, ArticleService articleService) {
        this.proposalRepository = proposalRepository;
        this.userService = userService;
        this.articleService = articleService;
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
    public List<Proposal> readProposalVDLVByIdUser(long id) {
        return proposalRepository.readProposalVDLVByIdUser(id);
    }

    @Override
    public List<Proposal> readProposalByIdArticle(long id) {
        return proposalRepository.readProposalByIdArticle(id);
    }

    //TODO : Pense a faire la mise a jour avant la création de la proposition car sinon y aura un soucis
    //TODO suite : sur le ranking, vue que l'on fait un +1 sur le rank.

    @Transactional
    @Override
    public void createProposal(long id_article, int pointProposal) {
        //je fais la mise à jour des rank en premier
        this.proposalRepository.updateRankByArticle(id_article);

        //TODO : pense a faire la vérification du Wallet de l'utilisateur

        // puis le crée la nouvelle enchère
        Proposal newProposal = new Proposal();
        newProposal.setPointProposal(pointProposal);
        newProposal.setDateProposal(LocalDateTime.now());
        newProposal.setRanking(1);
        newProposal.setBuyer(userService.readById(userService.getIdLoggedUser()));

        newProposal.setArticle(articleService.readById(id_article));

        proposalRepository.createProposal(newProposal);
    }

    @Override
    public void updateRankByArticle(long id) {
        this.proposalRepository.updateRankByArticle(id);
    }
}

