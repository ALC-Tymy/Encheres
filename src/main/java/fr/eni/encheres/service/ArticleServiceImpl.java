package fr.eni.encheres.service;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.DeliveryAddress;
import fr.eni.encheres.entity.dto.ArticleLog;
import fr.eni.encheres.entity.dto.CreateArticleDTO;
import fr.eni.encheres.repository.ArticleRepository;
import fr.eni.encheres.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final DeliveryAddressService deliveryAddressService;
    ArticleRepository articleRepository;
    DeliveryAddressRepository deliveryAddressRepository;
    UserService userService;

    public ArticleServiceImpl(ArticleRepository articleRepository, DeliveryAddressRepository deliveryAddressRepository, UserService userService, DeliveryAddressService deliveryAddressService) {
        this.articleRepository = articleRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.userService = userService;
        this.deliveryAddressService = deliveryAddressService;
    }

    @Override
    public void createArticle(Article article) {
        this.articleRepository.createArticle(article);
    }

    @Override
    public List<Article> readAll() {
        return this.articleRepository.readAll();
    }

    @Override
    public List<Article> readFullAll() {
        return this.articleRepository.readFullAll();
    }

    @Override
    public List<Article> readFullEC() {
        return this.articleRepository.readFullEC();
    }

    @Override
    public List<Article> readFullCR() {
        return this.articleRepository.readFullCR();
    }

    @Override
    public Article readById(long id) {
        return this.articleRepository.readById(id);
    }

    @Override
    public void updateArticle(Article article) {
        this.articleRepository.updateArticle(article);
    }

    @Override
    public void deleteArticle(long id) {
        this.articleRepository.deleteArticle(id);
    }

    @Override
    public List<Article> readArticleCRByIdSeller(long id) {
        return articleRepository.readArticleCRByIdSeller(id);
    }

    @Override
    public List<Article> readArticleECByIdSeller(long id) {
        return articleRepository.readArticleECByIdSeller(id);
    }

    @Override
    public List<Article> readArticleVDLVByIdSeller(long id) {
        return articleRepository.readArticleVDLVByIdSeller(id);
    }

    /**
     * Crée un nouvel article à partir d'un DTO.
     * Associe une adresse de livraison existante ou nouvellement créée,
     * puis persiste l'article en base de données.
     */
    @Transactional
    @Override
    public void createArticleDTO(CreateArticleDTO articleDTO) {

        // Récupère ou crée l'adresse de livraison associée à l'article
        DeliveryAddress addDeliAddr = deliveryAddressService.existingCreate(
                articleDTO.getAddress(),
                articleDTO.getZipCode(),
                articleDTO.getCity()
        );

        Article addArticle = new Article(
                articleDTO.getName(),
                articleDTO.getDescription(),
                articleDTO.getOriginalPoint(),
                articleDTO.getBeginningDate(),
                articleDTO.getEndingDate(),
                articleDTO.getCategory(),
                articleDTO.getSeller()
        );

        // Associe l'adresse de livraison et le vendeur à l'article
        addArticle.setDeliveryAddress(addDeliAddr);
        addArticle.setSeller(this.userService.readById(userService.getIdLoggedUser()));

        // Persiste l'article en base de données
        articleRepository.createArticle(addArticle);
    }

    @Transactional
    @Override
    public List<ArticleLog> updateCRtoECWithLogs() {
        List<ArticleLog> articles = articleRepository.findCRtoEC();
        if (!articles.isEmpty()) {
            articleRepository.updateCRtoEC();
        }
        return articles;
    }

    @Transactional
    @Override
    public List<ArticleLog> updateECtoVDWithLogs() {
        List<ArticleLog> articles = articleRepository.findECtoVD();
        if (!articles.isEmpty()) {
            articleRepository.updateECtoVD();
        }
        return articles;
    }

    @Transactional
    @Override
    public int updateCRtoEC() {
        return articleRepository.updateCRtoEC();
    }


    @Transactional
    @Override
    public int updateECtoVD() {
        return articleRepository.updateECtoVD();
    }


}
