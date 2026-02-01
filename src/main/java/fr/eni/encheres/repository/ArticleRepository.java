package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Article;

import java.util.List;

public interface ArticleRepository {

    void createArticle(Article article);

    List<Article> readAll();

    List<Article> readFullAll();

    List<Article> readFullEC();

    List<Article> readFullCR();

    Article readById(long id);

    void updateArticle(Article article);

    void deleteArticle(long id);

    List<Article> readArticleCRByIdSeller(long id);

    List<Article> readArticleECByIdSeller(long id);

    List<Article> readArticleVDLVByIdSeller(long id);
}
