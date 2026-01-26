package fr.eni.encheres.service;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
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
}
