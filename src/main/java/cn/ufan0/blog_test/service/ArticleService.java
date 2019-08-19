package cn.ufan0.blog_test.service;

import cn.ufan0.blog_test.entity.Article;

import java.util.List;

public interface ArticleService {

    Article getArticle(Integer id);

    List<Article> getAllArticle();

    List<Article> getAllPublicArticle();

    void updateArticle(Article article);

    void insertArticle(Article article);

    void deleteArticle(Integer id);

    void updateArticleRead_Count(Integer id);

}
