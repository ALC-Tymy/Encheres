package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.dto.ArticleLog;

import java.util.List;

public interface ArticleRepository {

    void createArticle(Article article);

    List<Article> readAll();

    List<Article> readFullAll();

    Article readById(long id);

    void updateArticle(Article article);

    void deleteArticle(long id);

    List<Article> readArticleCRByIdSeller(long id);

    List<Article> readArticleECByIdSeller(long id);

    List<Article> readArticleVDLVByIdSeller(long id);

    List<ArticleLog> findCRtoEC();

    List<ArticleLog> findECtoVD();

    int updateCRtoEC();

    int updateECtoVD();
}
