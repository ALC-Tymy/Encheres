package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Article;

import java.util.List;

public interface ArticleRepository {

    void createArticle(Article article);

    List<Article> readAll();

    Article readById(long id);

    void updateArticle(Article article);

    void deleteArticle(long id);
}
