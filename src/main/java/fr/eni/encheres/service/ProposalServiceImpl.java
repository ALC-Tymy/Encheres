package fr.eni.encheres.service;

import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.entity.User;
import fr.eni.encheres.repository.ProposalRepository;
import fr.eni.encheres.service.exceptions.ProposalException;
import fr.eni.encheres.service.exceptions.SignUpException;
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
    public void createProposal(long id_article, int pointProposal) throws ProposalException {

        // Je récupère l'id de l'utilisateur connecté et je le stocke dans la variable idBuyer.
        long idBuyer = userService.getIdLoggedUser();

        // Je récupère le solde (wallet) de l'utilisateur pour vérifier s'il peut faire une proposition.
        long walletUser = proposalRepository.checkWalletPointToPointProposal(idBuyer);

        // Je récupère le prix / nombre de points requis pour l'article en cours et je le stocke dans finalPointInProgress.
        long finalPointInProgress = articleService.finalPointInProgress(id_article);

        // Je vérifie si l'utilisateur est déjà classé n°1 sur cet article, et je renvoie un message d'erreur si c'est le cas.
        if (proposalRepository.checkUserRankOne(id_article, idBuyer)) {
            throw new ProposalException("Vous avez déjà la meilleure proposition");
        }

        // Je vérifie que l'utilisateur a suffisamment de crédit pour faire la proposition.
        if (walletUser >= finalPointInProgress) {

            // Je mets à jour les ranks des propositions pour cet article (l'ancienne meilleure proposition descend).
            this.proposalRepository.updateRankByArticle(id_article);

            // Je débite le walletPoint et je crédite le walletPending avec le montant de la proposition.
            this.proposalRepository.creditWalPendingAndDebitWalPoint(idBuyer, pointProposal);

        } else {
            throw new ProposalException("Vous n'avez pas assez de crédit");
        }

        // Puis je crée la nouvelle enchère / proposition.
        Proposal newProposal = new Proposal();
        newProposal.setPointProposal(pointProposal);
        newProposal.setDateProposal(LocalDateTime.now());
        newProposal.setRanking(1);
        newProposal.setBuyer(this.userService.readById(userService.getIdLoggedUser()));
        newProposal.setArticle(articleService.readById(id_article));
        proposalRepository.createProposal(newProposal);
    }


}

