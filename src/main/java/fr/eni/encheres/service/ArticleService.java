package fr.eni.encheres.service;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.dto.CreateArticleDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleService {

    void createArticle(Article article);
    List<Article> readAll();
    Article readById(long id);
    void updateArticle(Article article);
    void deleteArticle(long id);
    List<Article> readArticleCRByIdSeller(long id);
    List<Article> readArticleECByIdSeller(long id);

    @Transactional
    void createArticleDTO (CreateArticleDTO articleDTO);
}
