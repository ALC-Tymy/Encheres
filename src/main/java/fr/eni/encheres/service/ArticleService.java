package fr.eni.encheres.service;

import fr.eni.encheres.entity.Article;
import java.util.List;

public interface ArticleService {

    void createArticle(Article article);
    List<Article> readAll();
    Article readById(long id);
    void updateArticle(Article article);
    void deleteArticle(long id);

}
