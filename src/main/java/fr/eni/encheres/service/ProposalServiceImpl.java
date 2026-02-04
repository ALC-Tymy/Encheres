package fr.eni.encheres.service;

import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.repository.ProposalRepository;
import fr.eni.encheres.service.exceptions.ProposalException;
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

    @Transactional
    @Override
    public void createProposal(long id_article, int pointProposal) throws ProposalException {
        // Je récupère l'id de l'utilisateur connecté et je le stocke dans la variable idBuyer.
        long idBuyer = this.userService.getIdLoggedUser();
        // Je récupère le solde (wallet) de l'utilisateur pour vérifier s'il peut faire une proposition.
        long walletUser = this.proposalRepository.checkWalletPointToPointProposal(idBuyer);
        // Je récupère le prix de l'enchère en cours de l'article et le stocke dans une variable finalPoint
        Integer finalPoint = this.articleService.finalPointInProgress((int) id_article);
        // Je récupérer l'ancien n°1 (s'il existe) AVANT de modifier les ranks
        Long rankOneUserId = this.proposalRepository.getUserIdByRankOne(id_article);

        //0)
        if (finalPoint == null) {
            finalPoint = articleService.getOriginalPoint((int) id_article);
        }

        // 1) Vérifier que l'utilisateur a suffisamment de crédit
        if (walletUser < pointProposal) {
            throw new ProposalException("Vous n'avez pas assez de crédit");
        }
        System.out.println(id_article);
        System.out.println(pointProposal);
        System.out.println(finalPoint);
        // 2) Vérifier que la nouvelle proposition est supérieure à l'actuelle
        if (pointProposal <= finalPoint) {
            throw new ProposalException("Votre proposition doit être supérieure à l'offre actuelle");
        }

        // 3) Vérifier si l'utilisateur est déjà classé n°1
        if (this.proposalRepository.checkUserRankOne(id_article, idBuyer)) {
            throw new ProposalException("Vous avez déjà la meilleure proposition");
        }

        // 4) Rembourser l'ancien n°1 s'il existait
        if (rankOneUserId != null) {
            this.proposalRepository.creditWalPointAndDebitWalPending(rankOneUserId, finalPoint);
        }
        // 5) Débiter le nouveau proposant
        this.proposalRepository.creditWalPendingAndDebitWalPoint(idBuyer, pointProposal);

        // 6) Mettre à jour les ranks (l'ancien n°1 passe en n°2 ect...)
        this.proposalRepository.updateRankByArticle(id_article);

        //8) Mettre à jour le final_point dans [USER] au prix du point_proposal
        this.proposalRepository.updatePointProposalToFinalPoint(id_article, pointProposal);
        // 9) Créer la nouvelle proposition
        Proposal newProposal = new Proposal();
        newProposal.setPointProposal(pointProposal);
        newProposal.setDateProposal(LocalDateTime.now());
        newProposal.setRanking(1);
        newProposal.setBuyer(this.userService.readById(idBuyer));
        newProposal.setArticle(this.articleService.readById(id_article));
        proposalRepository.createProposal(newProposal);
    }

    }



