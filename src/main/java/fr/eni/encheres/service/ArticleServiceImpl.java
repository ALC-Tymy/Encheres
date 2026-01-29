package fr.eni.encheres.service;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.DeliveryAddress;
import fr.eni.encheres.entity.dto.CreateArticleDTO;
import fr.eni.encheres.repository.ArticleRepository;
import fr.eni.encheres.repository.DeliveryAddressRepository;
import org.springframework.data.domain.Score;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    ArticleRepository articleRepository;
    DeliveryAddressRepository deliveryAddressRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, DeliveryAddressRepository deliveryAddressRepository) {
        this.articleRepository = articleRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
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

//        Collections.sort(articleRepository.readArticleCRByIdSeller(id), new Comparator<Article>() {
//            public int compare(Article a, Article b) {
//                return a.getBeginningDate().compareTo(b.getBeginningDate());
//            }
//        });

        return articleRepository.readArticleCRByIdSeller(id);
    }

    @Override
    public List<Article> readArticleECByIdSeller(long id){
        return articleRepository.readArticleECByIdSeller(id);
    }

    @Transactional
    @Override
    public void createArticleDTO(CreateArticleDTO articleDTO) {

        DeliveryAddress addDeliAddr = new DeliveryAddress(
                articleDTO.getAddress(),
                articleDTO.getZipCode(),
                articleDTO.getCity()
        );
        deliveryAddressRepository.createDeliveryAddress(addDeliAddr);

        Article addArticle = new Article(
                articleDTO.getName(),
                articleDTO.getDescription(),
                articleDTO.getOriginalPoint(),
                articleDTO.getBeginningDate(),
                articleDTO.getEndingDate(),
                articleDTO.getCategory()
        );

        addArticle.setDeliveryAddress(addDeliAddr);

        articleRepository.createArticle(addArticle);
    }
}
