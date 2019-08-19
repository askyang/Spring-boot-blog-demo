package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.entity.Article;
import cn.ufan0.blog_test.mapper.ArticleMapper;
import cn.ufan0.blog_test.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    // 若是上面自动注入报错，提示无法自动注入，请忽略，没必要去加上其他注解修补，如此就好，只是有点碍眼。


    /*
        @Cacheable(cacheNames = "article")
        JSR107的注解为@CacheResult，springboot建议不要和@Cacheable混合使用。
        https://spring.io/blog/2014/04/14/cache-abstraction-jcache-jsr-107-annotations-support
     */
    @Override
    public Article getArticle(Integer id) {
        return articleMapper.getArticle(id);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleMapper.getAllArticle();
    }

    @Override
    public List<Article> getAllPublicArticle() {
        return articleMapper.getAllPublicArticle();
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }

    @Override
    public void updateArticleRead_Count(Integer id) {
        articleMapper.updateArticleRead_Count(id);
    }
}
