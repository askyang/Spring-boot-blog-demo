package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.Article;
import cn.ufan0.blog_test.service.ArticleService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public Object getArticle(@RequestParam(value = "id", required = false) Integer id) {
        if (id == null) {
            return articleService.getAllPublicArticle();
        } else {
            articleService.updateArticleRead_Count(id);
            return articleService.getArticle(id);
        }
    }

    /**
     * 文章编辑接口
     * 只有两处会调用，也仅回应以下两种请求
     * 1. 文章标题、描述和正文有更新时：此时需要更新编辑时间和编辑次数
     * 2. 修改文章状态时：此时不需要更新编辑时间和编辑次数
     */
    @Secured("ROLE_USER")
    @PutMapping("/article")
    public void updateArticle(Article article) {
        if (article.getId() != null) {

            /*
             * 第一种情况调用：标题、描述和正文中至少有一处更新时才更新编辑时间和编辑次数
             * 判断条件：当标题、描述和正文中至少有一处不为空，说明数据来自editArticle.html
             */
            if (article.getTitle() != null || article.getDescription() != null || article.getContent() != null) {
                // 上次修改时间更改为当前时间，时区问题需要加上8小时
                // article.setLast_update_time(new Timestamp(System.currentTimeMillis() + 28800000));
                // 已经在数据库修改时间格式为DATATIME，无时区问题
                article.setLast_update_time(new Timestamp(System.currentTimeMillis()));
                // 执行更新操作
                articleService.updateArticle(article);
            }

            /*
             * 第二种情况调用：仅修改文章状态
             * 判断条件：编辑次数为零，则说明参数来自article.html，需求为修改文章状态
             */
            if (article.getUpdate_count() == null) {
                articleService.updateArticle(article);
            }
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/article")
    public void insertArticle(Article article) {
        if (article.getTitle() != null) {
            // 执行插入操作
            articleService.insertArticle(article);
        }
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/article")
    public void deleteArticle(Integer id) {
        if (id != null) {
            articleService.deleteArticle(id);
        }
    }
}
